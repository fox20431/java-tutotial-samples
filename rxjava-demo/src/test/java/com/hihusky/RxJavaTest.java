package com.hihusky;

import io.reactivex.rxjava3.core.Observable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RxJavaTest {
    String result = "";
    String[] letters = {"a", "b", "c"};

    /**
     * create observable
     */
    @Test
    public void test() {
        Observable<String> observable = Observable.just("Hello");
        observable.subscribe(s -> result = s);

        assertTrue(result.equals("Hello"));
    }

    /**
     * onNext, onError, and onCompleted
     */
    @Test
    public void test2() {
        Observable<String> observable = Observable.fromArray(letters);
        observable.subscribe(
                i -> result += i,  //OnNext
                Throwable::printStackTrace, //OnError
                () -> result += "_Completed" //OnCompleted
        );
        assertTrue(result.equals("abc_Completed"));
    }

    @Test
    public void test3() {
        Observable.fromArray(letters)
                .map(String::toUpperCase)
                .subscribe(letter -> result += letter);
        assertTrue(result.equals("ABC"));
    }

    @Test
    public void test4() {
        Observable.fromArray(letters)
                .scan(new StringBuilder(), StringBuilder::append)
                .subscribe(total -> result += total.toString());
        assertTrue(result.equals("aababc"));
    }
}
