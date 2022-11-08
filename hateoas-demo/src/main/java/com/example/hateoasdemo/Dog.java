package com.example.hateoasdemo;

public class Dog {
    private String name;
    private String bark;

    public Dog() {
    }

    public Dog(String name, String bark) {
        this.name = name;
        this.bark = bark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBark() {
        return bark;
    }

    public void setBark(String bark) {
        this.bark = bark;
    }
}
