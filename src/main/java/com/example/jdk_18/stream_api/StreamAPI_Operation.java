package com.example.jdk_18.stream_api;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @ProjectName:
 * @Package: com.example.jdk_18.stream_api
 * @ClassName: StreamAPI_Operation
 * @Description: 测试 Stream 的中间操作
 * @Author: Mr.Vincent
 * @CreateDate: 2020/2/29 22:12
 * @Version: 1.0.0
 */
public class StreamAPI_Operation {

    //筛选与切片
    @Test
    public void m1() {
        List<Employee> list = EmployeeData.getEmployees();

        //filter(Predicate p)：接收 Lambda ，从流中排除某些元素。
        Stream<Employee> stream = list.stream();
        stream.filter(employee -> employee.getSalary() > 7000).forEach(System.out::println);
        System.out.println();

        //limit(long maxSize)：截断流，使其元素不超过给定数量
        list.stream().limit(3).forEach(System.out::println);
        System.out.println();


        //skip(long n)：跳过元素，返回一个扔掉了前 n 个元素的流；若流中元素不足 n 个，则返回一个空流；与 limit(n) 互补。
        list.stream().skip(3).forEach(System.out::println);
        System.out.println();


        //distinct()：筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素。

        list.add(new Employee(1010, "刘强东", 40, 8000.00));
        list.add(new Employee(1010, "刘强东", 41, 8000.00));
        list.add(new Employee(1010, "刘强东", 40, 8000.00));
        list.add(new Employee(1010, "刘强东", 40, 8000.00));
        list.add(new Employee(1010, "刘强东", 40, 8000.00));
        System.out.println(list);

        list.stream().distinct().forEach(System.out::println);
    }

    //映射
    @Test
    public void m2() {
        //map(Function f)：接收一个函数作为参数，该函数会被应用到每个元 素上，并将其映射成一个新的元素。
        List<String> list = Arrays.asList("aa", "bb", "cc");
        list.stream().map(s -> s.toUpperCase()).forEach(System.out::println);

        //获取员工姓名长度大于3的员工姓名
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().map(Employee::getName).filter(name -> name.length() > 3).forEach(System.out::println);

        //flatMap(Function f)：接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
        Stream<Character> characterStream = list.stream().flatMap(StreamAPI_Operation::fromStringStream);
        characterStream.forEach(System.out::println);
    }

    public static Stream<Character> fromStringStream(String str) {
        ArrayList<Character> characters = new ArrayList<>();
        for (char c : str.toCharArray()) {
            characters.add(c);
        }
        return characters.stream();
    }

    //排序
    @Test
    public void m3() {
        //sorted()：产生一个新流，其中按自然顺序排序。
        List<Integer> list = Arrays.asList(12, 34, 53, 221, 45, -98, 7, 98);
        list.stream().sorted().forEach(System.out::println);
        System.out.println();

        //sorted(Comparator com)：产生一个新流，其中按比较器顺序排序。
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted((e1, e2) -> {
            int ageVal = Integer.compare(e1.getAge(), e2.getAge());
            if (ageVal != 0) {
                return ageVal;
            } else {
                return Double.compare(e1.getSalary(), e2.getSalary());
            }
        }).forEach(System.out::println);
    }
}












