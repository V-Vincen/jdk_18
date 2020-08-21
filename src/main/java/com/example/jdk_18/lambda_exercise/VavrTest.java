package com.example.jdk_18.lambda_exercise;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.control.Option;
import org.junit.Test;

/**
 * @author vincent
 */
public class VavrTest {

    @Test
    public void t() {
        Tuple2<String, Integer> tuple2 = Tuple.of("Hello", 100);
        Tuple2<String, Integer> updatedTuple2 = tuple2.map(String::toUpperCase, v -> v * 5);
        String result = updatedTuple2.apply((str, number) -> String.join(", ", str, number.toString()));
        System.out.println(result);
    }

    @Test
    public void t2() {
        Option<String> str = Option.of("Hello");
        Option<Integer> map = str.map(String::length);
        Option<Integer> integers = str.flatMap(v -> Option.of(v.length()));
    }
}
