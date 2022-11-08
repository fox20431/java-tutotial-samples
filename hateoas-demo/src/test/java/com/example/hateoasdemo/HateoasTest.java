package com.example.hateoasdemo;

import org.junit.jupiter.api.Test;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.LinkRelation;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class HateoasTest {

    @Test
    void test1 () {
        Link link = Link.of("/something");
        assertThat(link.getHref()).isEqualTo("/something");
        assertThat(link.getRel()).isEqualTo(IanaLinkRelations.SELF);

        link = Link.of("/something", "my-rel");
        assertThat(link.getHref()).isEqualTo("/something");
        assertThat(link.getRel()).isEqualTo(LinkRelation.of("my-rel"));
    }

    @Test
    void test2 () {
        Link link = Link.of("/{segment}/something{?parameter}");
        assertThat(link.isTemplated()).isTrue();
        assertThat(link.getVariableNames()).contains("segment", "parameter");

        Map<String, Object> values = new HashMap<>();
        values.put("segment", "path");
        values.put("parameter", 42);

        assertThat(link.expand(values).getHref())
                .isEqualTo("/path/something?parameter=42");
    }

}
