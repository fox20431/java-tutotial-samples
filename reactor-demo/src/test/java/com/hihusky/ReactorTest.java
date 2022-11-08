package com.hihusky;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import static org.assertj.core.api.Assertions.*;

public class ReactorTest {
    @Test
    void test() {
        Mono<Integer> mono = Mono.just(1);
        Flux<Integer> flux = Flux.just(1, 2, 3, 4);
        mono.subscribe(System.out::println);
    }
    @Test
    void test2() {
        List<Integer> elements = new ArrayList<>();
        int[] elements2 = new int[]{1, 2, 3, 4};
        Flux.just(1, 2, 3, 4)
                .log()
                .subscribe(elements::add);
        assertThat(elements).containsExactly(1, 2, 3, 4);
    }
    @Test
    void test3() {
    }
}
