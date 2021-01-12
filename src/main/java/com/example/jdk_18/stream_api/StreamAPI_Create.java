package com.example.jdk_18.stream_api;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @ProjectName:
 * @Package: com.example.jdk_18.stream_api
 * @ClassName: StreamAPI
 * @Description: 1.Stream 关注的是对数组的运算，与 CPU 打交道集合关注的是数组的存储，与内存打交道
 * （1） Stream 自己不会存储元素。
 * （2） Stream 不会改变源对象。相反，他们会返会一个持有结果的新 Stream。
 * （3） Stream 操作是延迟执行，这意味着他们会等到需要结果的时候才执行。
 * <p>
 * 2.Stream 执行流程
 * （1） Stream 的实例化
 * （2） 一个中间操作链，对数据源的数据进行处理
 * （3） 终止操作
 * @Author: Mr.Vincent
 * @CreateDate: 2019/12/16 16:44
 * @Version: 1.0.0
 */
public class StreamAPI_Create {

    //创建 Stream 方式一：通过集合
    @Test
    public void m1() {
        List<Employee> employees = EmployeeData.getEmployees();
        //default Stream<E> stream()：返回一个顺序流
        Stream<Employee> stream = employees.stream();

        //default Stream<E> parallelstream()：返回一个并行流
        Stream<Employee> parallelStream = employees.parallelStream();
    }

    //创建 Stream 方式二：通过数组
    @Test
    public void m2() {
        //调用 Arrays 类的 static <T> Stream<T> stream(T[] array)
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        IntStream stream = Arrays.stream(arr);

        Employee e1 = new Employee(1001, "Tom");
        Employee e2 = new Employee(1002, "Jerry");
        Employee[] aE = new Employee[]{e1, e2};
        Stream<Employee> aStream = Arrays.stream(aE);
    }

    //创建 Stream 方法三：通过 Stream 的 of()
    @Test
    public void m3() {
        //public static<T> Stream<T> of(T... values)：返回一个流
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
    }

    //创建 Stream 方式四：创建无限流
    @Test
    public void m4() {
        //迭代 public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        //遍历前10个偶数
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);

        //生成 public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}








