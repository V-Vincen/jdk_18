package com.example.jdk_18.method_constructor_references;


import org.junit.Test;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @ProjectName:
 * @Package: com.example.jdk_18.method_constructor_references
 * @ClassName: ConstructorReferences
 * @Description: 构造方法引用：
 * 1) 构造器引用：
 * 组成语法格式：Class::new
 * 和方法引用类似，函数接口的抽象方法的形参列表和构造器的形参列表一致；
 * 抽象方法的返回值类型即为构造器所属的类的类型。
 * <p>
 * 2) 数组引用：
 * 可以把数组看做事一个特殊的类，则写法与构造器引用一致。
 * @Author: Mr.Vincent
 * @CreateDate: 2019/9/10 16:47
 * @Version: 1.0.0
 */
public class ConstructorReferences {

    //构造器引用
    //Supplier 中的 T get() 与 Person()
    @Test
    public void t1() {
        //原来的写法
        Supplier<Person> supplier = new Supplier<Person>() {
            @Override
            public Person get() {
                return new Person();
            }
        };
        System.out.println(supplier.get());

        //lambda的写法
        Supplier<Person> supplierL = () -> new Person();
        System.out.println(supplierL.get());

        //构造器引用
        Supplier<Person> supplierM = Person::new;
        System.out.println(supplierM.get());
    }

    //Function 中的 R apply(T t)
    @Test
    public void t2() {
        //原来的写法
        Function<String, Person> function = new Function<String, Person>() {
            @Override
            public Person apply(String s) {
                return new Person(s);
            }
        };
        System.out.println(function.apply("小微"));

        //lambda的写法
        Function<String, Person> functionL = s -> new Person(s);
        System.out.println(functionL.apply("小微"));

        //构造器引用
        Function<String, Person> functionM = Person::new;
        System.out.println(functionM.apply("小微"));
    }

    //BiFunction 中的 apply(T t,U u)
    @Test
    public void t3() {
        //原来的写法
        BiFunction<String, LocalDate, Person> biFunction = new BiFunction<String, LocalDate, Person>() {
            @Override
            public Person apply(String s, LocalDate localDate) {
                return new Person(s, localDate);
            }
        };
        Person person = biFunction.apply("威仔", LocalDate.of(2010, 12, 13));
        System.out.println(person);

        //lambda的写法
        BiFunction<String, LocalDate, Person> biFunctionL = (s, lD) -> new Person(s, lD);
        Person personL = biFunctionL.apply("威仔", LocalDate.of(2010, 12, 13));
        System.out.println(personL);

        //构造器引用
        BiFunction<String, LocalDate, Person> biFunctionM = Person::new;
        Person personM = biFunctionM.apply("威仔", LocalDate.of(2010, 12, 13));
        System.out.println(personM);
    }
//======================================================================================================================


    //数组引用
    //Function 中的 R apply(T t)
    @Test
    public void t4() {
        //原来的写法
        Function<Integer, String[]> function = new Function<Integer, String[]>() {
            @Override
            public String[] apply(Integer integer) {
                return new String[integer];
            }
        };
        String[] apply = function.apply(10);
        System.out.println(Arrays.toString(apply));

        //lambda的写法
        Function<Integer, String[]> functionL = length -> new String[length];
        String[] applyL = functionL.apply(10);
        System.out.println(Arrays.toString(applyL));

        //数组引用
        Function<Integer, String[]> functionM = String[]::new;
        String[] applyM = function.apply(10);
        System.out.println(Arrays.toString(applyM));
    }
}
