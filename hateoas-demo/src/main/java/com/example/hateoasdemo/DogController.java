package com.example.hateoasdemo;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;

@RestController
public class DogController {

    @GetMapping("/")
    public HttpEntity<EntityModel<Dog>> show() {
        Dog dog = new Dog("kk", "woof");

        Link link = linkTo(DogController.class).withRel("people");
        link.andAffordance(afford(methodOn(DogController.class).showAll()));
        EntityModel<Dog> dogEntityModel = EntityModel.of(dog, link);

        return new ResponseEntity<>(dogEntityModel, HttpStatus.OK);
    }

    @GetMapping("/test")
    public String showAll() {
        System.out.println("hello");
        return "hello";
    }
}
