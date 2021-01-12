package com.example.jdk_18.functional_interfaces;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @ProjectName:
 * @Package: com.example.jdk_18.functional
 * @ClassName: Functional
 * @Description: Java 内置的4大核心函数式接口
 * 1) 消费型接口 Consumer<T>：void accept(T t)
 * 2) 供给型接口 Supplier<T>：T get()
 * 3) 函数型接口 Function<T,R>：R apply(T t)
 * 4) 断定型接口 Predicate<T>：boolean test(T t)
 * @Author: Mr.Vincent
 * @CreateDate: 2019/9/10 2:27
 * @Version: 1.0.0
 */
public class Functional {

    //作为参数传递 Lambda 表达式（自定义函数式接口）
    @Test
    public void m() {
        //原来写法
        String handler = strHandler("帅是没有道理的 ", new MyFunction<String>() {
            @Override
            public String getValue(String s) {
                return s.trim();
            }
        });
        System.out.println(handler);

        //Lambda 表达式的写法
        String trimStr = strHandler("帅是没有道理的 ", str -> str.trim());
        System.out.println(trimStr);
        String upperStr = strHandler("abcdefg", (str) -> str.toUpperCase());
        System.out.println(upperStr);
        String newStr = strHandler("have a good night", (str) -> str.substring(2, 5));
        System.out.println(newStr);
    }

    public String strHandler(String str, MyFunction<String> mf) {
        return mf.getValue(str);
    }
//======================================================================================================================


    //消费型接口 Consumer<T>：void accept(T t)
    @Test
    public void m1() {
        //原来的写法
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("学习太累，去天上人间买了瓶矿泉水，价格为：" + aDouble);
            }
        });

        //Lambda 表达式的写法
        happyTime(500, money -> System.out.println("学习太累，去天上人间买了瓶矿泉水，价格为：" + money));

    }

    public void happyTime(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }
//======================================================================================================================


    //断定型接口 Predicate<T>：boolean test(T t)
    @Test
    public void m2() {
        //原来的写法
        List<String> list = Arrays.asList("北京", "南京", "天津", "东京", "西京", "普京");
        List<String> filterStrs = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(filterStrs);

        //Lambda 表达式的写法
        List<String> filterStrsL = filterString(list, s -> s.contains("京"));
        System.out.println(filterStrsL);
    }

    //需求：根据给定的规则，过滤集合中的字符串，此规则由 Predicate 的方法决定
    public List<String> filterString(List<String> list, Predicate<String> predicate) {
        ArrayList<String> filterList = new ArrayList<>();
        for (String s : list) {
            if (predicate.test(s)) {
                filterList.add(s);
            }
        }
        return filterList;
    }
//======================================================================================================================


    //供给型接口 Supplier<T>：T get()
    @Test
    public void m3() {
        //原来的写法
        List<Integer> numList = getNumList(10, new Supplier<Integer>() {
            @Override
            public Integer get() {
                return (int) (Math.random() * 100);
            }
        });
        System.out.println(numList);

        //Lambda 表达式的写法
        List<Integer> numListL = getNumList(10, () -> (int) (Math.random() * 100));
        System.out.println(numListL);

    }

    //需求：生成指定个数的整数，并放入集合中
    public List<Integer> getNumList(int num, Supplier<Integer> supplier) {
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer n = supplier.get();
            arrayList.add(n);
        }
        return arrayList;
    }
//======================================================================================================================


    //函数型接口 Function<T,R>：R apply(T t)
    @Test
    public void m4() {
        //原来的写法
        String s = sHandler("\t\t Vincent帅到掉渣...  ", new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.trim();
            }
        });
        System.out.println(s);

        //Lambda 表达式的写法
        String sL = strHandler("\t\t Vincent帅到掉渣...  ", str -> str.trim());
        System.out.println(sL);

    }

    //需求：用于处理字符串
    public String sHandler(String str, Function<String, String> function) {
        return function.apply(str);
    }


}













