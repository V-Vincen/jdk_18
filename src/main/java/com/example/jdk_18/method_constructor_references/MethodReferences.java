package com.example.jdk_18.method_constructor_references;


import org.junit.Test;

import java.io.PrintStream;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
  * @ProjectName:
  * @Package:        com.example.jdk_18.method_constructor_references
  * @ClassName:      MethodReferences
  * @Description:
  *                  方法引用：
  *                  使用情景：当要传递给 Lambda 体的操作，已经有实现的方法了，可以使用方法引用。
  *
  *                  方法引用，本质上就是 Lambda 表达式，而 Lambda 表达式作为函数接口的实例。所以方法引用，也是函数式接口的实例。
  *
  *                  使用格式：类（或对象） :: 方法名
  *
  *                  具体分为如下三种情况：
  *                  1) 对象 :: 非静态方法
  *                  2) 类 :: 静态方法
 *                   3) 类 :: 非静态方法
 *
 *                   方法引用的使用要求：实现接口的抽象方法的参数列表和返回值类型，必须与方法引用的方法的参数列表和返回值类型保持一致。
  *
  *
  * @Author:         Mr.Vincent
  * @CreateDate:     2019/9/10 14:38
  * @Version:        1.0.0
  */
public class MethodReferences {

    //情况一：对象 :: 实例方法
    //Consumer 中的 void accept(T t) 与 PrintStream 中的 void println(T t)
    @Test
    public void t1() {
        //原来的写法
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("上海市");

        //lambda 写法
        Consumer<String> consumerL = str -> System.out.println(str);
        consumerL.accept("上海");

        //方法引用
        PrintStream out = System.out;
        Consumer<String> consumerM = out::println;
        consumerM.accept("shanghai");
    }


    //Supplier 中的 T get() 与 Person 中的 String getName()
    @Test
    public void t2() {
        Person person = new Person("小威", LocalDate.of(2016, 9, 1));

        //原来的写法
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return person.getName();
            }
        };
        System.out.println(supplier.get());

        //lambda 写法
        Supplier<String> supplierL = () -> person.getName();
        System.out.println(supplierL.get());

        // 方法引用
        Supplier<String> supplierM = person::getName;
        System.out.println(supplierM.get());
    }
//======================================================================================================================


    //情况二：类 :: 静态方法
    //Comparator 中的 int compare(T t1,T t2) 与 Integer 中的 int compare(T t1,T t2)
    @Test
    public void t3() {
        //原来的写法
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        System.out.println(comparator.compare(520, 1314));

        //lambda 写法
        Comparator<Integer> comparatorL = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println(comparatorL.compare(100, 99));

        // 方法引用
        Comparator<Integer> comparatorM = Integer::compareTo;
        System.out.println(comparatorM.compare(123, 321));
    }

    //Function 中 R apply(T t) 与 Math 中 Long round(Double d)
    @Test
    public void t4() {
        //原来的写法
        Function<Double, Long> function = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }
        };
        System.out.println(function.apply(13.7));

        //lambda 写法
        Function<Double, Long> functionL = d -> Math.round(d);
        System.out.println(functionL.apply(13.4));

        // 方法引用
        Function<Double, Long> functionM = Math::round;
        System.out.println(functionM.apply(13.9));
    }
//======================================================================================================================


    //情况三：类 :: 实例方法（有难度）
    //Comparator 中的 int compare(T t1,T t2) 与 String 中的 int t1.compareTo(t2)
    @Test
    public void t5() {
        //原来的写法
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println(comparator.compare("abc", "abd"));

        //lambda 写法
        Comparator<String> comparatorL = (o1, o2) -> o1.compareTo(o2);
        System.out.println(comparatorL.compare("abc", "abd"));

        // 方法引用
        Comparator<String> comparatorM = String::compareTo;
        System.out.println(comparatorM.compare("abd", "abc"));
    }

    //BiPredicate 中的 boolean test(T t1,T t2) 与 String 中的 boolean t1.equals(t2)
    @Test
    public void t6() {
        //原来的写法
        BiPredicate<String, String> biPredicate = new BiPredicate<String, String>() {
            @Override
            public boolean test(String s, String s2) {
                return s.equals(s2);
            }
        };
        System.out.println(biPredicate.test("abc", "abd"));

        //lambda 写法
        BiPredicate<String, String> biPredicateL = (s1, s2) -> s1.equals(s2);
        System.out.println(biPredicateL.test("abc", "abd"));

        // 方法引用
        BiPredicate<String, String> biPredicateM = String::equals;
        System.out.println(biPredicateM.test("abc", "abd"));
    }

    //Function 中的 R apply(T t) 与 Person 中的 String getName()
    @Test
    public void t7() {
        Person person = new Person("Vincent", LocalDate.of(1991, 1, 28));

        //原来的写法
        Function<Person, String> function = new Function<Person, String>() {
            @Override
            public String apply(Person person) {
                return person.getName();
            }
        };
        System.out.println(function.apply(person));


        //lambda 写法
        Function<Person, String> functionL = p -> p.getName();
        System.out.println(functionL.apply(person));

        // 方法引用
        Function<Person, String> functionM = Person::getName;
        System.out.println(functionM.apply(person));
    }
}
