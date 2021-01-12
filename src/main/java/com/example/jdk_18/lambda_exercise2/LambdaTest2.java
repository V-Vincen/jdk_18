package com.example.jdk_18.lambda_exercise2;

import com.google.common.collect.Lists;
import io.vavr.CheckedConsumer;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * @author vincent
 */
@Slf4j
public class LambdaTest2 {
    @Data
    private static class Apple {
        private Integer weight;
        private Double price;

        public Apple(Integer weight) {
            this.weight = weight;
        }
    }

    public List<Apple> initAppleList() {
        return Lists.newArrayList(
                new Apple(98),
                new Apple(88),
                new Apple(77)
        );
    }

    @Test
    public void streamTest() throws InterruptedException {
        List<Apple> appleList = initAppleList();
        Date begin = new Date();
        for (Apple apple : appleList) {
            apple.setPrice(5.0 * apple.getWeight() / 1000);
            Thread.sleep(1000);
        }
        Date end = new Date();
        log.info("苹果数量：{}个, 耗时：{}s", appleList.size(), (end.getTime() - begin.getTime()) / 1000);
        //14:56:26.666 [main] INFO com.example.jdk_18.lambda_exercise.LambdaTest2 - 苹果数量：3个, 耗时：3s
    }

    @Test
    public void parallelStreamTest() {
        List<Apple> appleList = initAppleList();
        Date begin = new Date();
        appleList.parallelStream().forEach(
                CheckedConsumer.<Apple>of(apple -> {
                    apple.setPrice(5.0 * apple.getWeight() / 1000);
                    Thread.sleep(1000);
                }).unchecked()
        );
        Date end = new Date();
        log.info("苹果数量：{}个, 耗时：{}s", appleList.size(), (end.getTime() - begin.getTime()) / 1000);
        //14:56:45.434 [main] INFO com.example.jdk_18.lambda_exercise.LambdaTest2 - 苹果数量：3个, 耗时：1s
    }
}
