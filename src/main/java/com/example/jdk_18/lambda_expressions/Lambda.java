package com.example.jdk_18.lambda_expressions;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @ProjectName:
 * @Package: com.example.jdk_18.lambda_expressions
 * @ClassName: Lambda
 * @Description: Lambda 表达式的语法使用(六中情况)
 * <p>
 * Lambda 表达式本质：作为函数式接口（只有一个抽象方法的接口）的实例，Lambda 表达式和方法引用,只能用在函数式接口上。
 * 总结：
 * -> 左边：lambda 形参列表的参数类型可以省略（类型推断）；如果 lambda 形参列表只有一个参数，其 '()' 可以省略
 * -> 右边：lambda 体应该使用 '{}' 包裹；如果 lambda 体只有一条执行语句（可以是 return 语句），可以省略 '{}' 和 return 关键字
 * @Author: Mr.Vincent
 * @CreateDate: 2019/9/9 17:11
 * @Version: 1.0.0
 */
public class Lambda {
    //语法格式一：无参，无返回值
    @Test
    public void m1() {
        //原来的写法
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Vincent帅到掉渣...");
            }
        };
        runnable.run();


        //Lambda 表达式的写法
        Runnable rL = () -> {
            System.out.println("Vincent帅到掉渣...");
        };
        rL.run();
    }


    //语法格式二：一个参数，无返回值
    @Test
    public void m2() {
        //原来的写法
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("谎言和誓言的区别是什么呢？");


        //Lambda 表达式的写法
        Consumer<String> cL = (String s) -> {
            System.out.println(s);
        };
        cL.accept("一个是听得人当真了，一个是说的人当真了......");
    }


    //语法格式三：数据类型可以省略，因为可由编译器推断得出，称为“类型推断”
    @Test
    public void m3() {
        //原来的写法
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("Vincent帅到吐血...");


        //Lambda 表达式的写法（类型推断）
        Consumer<String> cL = (s) -> {
            System.out.println(s);
        };
        cL.accept("Vincent帅到吐血...");
    }


    //语法格式四：若只需一个参数，参数的小括号可以省略
    @Test
    public void m4() {
        //原来的写法
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("Vincent帅到喷汁...");


        //Lambda 表达式的写法（类型推断）
        Consumer<String> cL = s -> {
            System.out.println(s);
        };
        cL.accept("Vincent帅到喷汁...");
    }


    //语法格式五：需要两个或两个以上的参数，多条执行语句，并且可以有返回值
    @Test
    public void m5() {
        //原来的写法
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println("o1:" + o1);
                System.out.println("o2:" + o2);
                return o1.compareTo(o2);
            }
        };
        int compare = comparator.compare(100, 99);
        System.out.println(compare);


        //Lambda 表达式的写法
        Comparator<Integer> cL = (o1, o2) -> {
            System.out.println("o1:" + o1);
            System.out.println("o2:" + o2);
            return o1.compareTo(o2);
        };
        int compareL = cL.compare(520, 1314);
        System.out.println(compareL);
    }


    //语法格式五：Lambda 体只有一条语句时，return 与大括号若有，都可省略
    @Test
    public void m6() {
        //原来的写法
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        int compare = comparator.compare(100, 99);
        System.out.println(compare);


        //Lambda 表达式的写法
        Comparator<Integer> cL = (o1, o2) -> o1.compareTo(o2);
        int compareL = cL.compare(520, 1314);
        System.out.println(compareL);
    }
}
