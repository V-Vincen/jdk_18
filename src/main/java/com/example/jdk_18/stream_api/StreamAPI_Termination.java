package com.example.jdk_18.stream_api;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ProjectName:
 * @Package: com.example.jdk_18.stream_api
 * @ClassName: StreamAPI_Termination
 * @Description: 测试 Stream 的终止操作
 * @Author: Mr.Vincent
 * @CreateDate: 2020/3/10 01:20
 * @Version: 1.0.0
 */
public class StreamAPI_Termination {

    //匹配与查找
    @Test
    public void m1() {
        List<Employee> employees = EmployeeData.getEmployees();

        //allMatch(Predicate p)：检查是否匹配所有元素
        //练习：是否所有员工的年龄都是大于18
        boolean allMatch = employees.stream().allMatch(employee -> employee.getAge() > 18);
        System.out.println(allMatch);
        System.out.println();

        //anyMatch(Predicate p)：检查是否至少匹配一个元素
        //练习：是否存员工的工资大于10000
        boolean anyMatch = employees.stream().anyMatch(employee -> employee.getSalary() > 10000);
        System.out.println(anyMatch);
        System.out.println();

        //noneMatch(Predicate p)：检查是否没有匹配所有元素
        //练习：是否存员工姓"雷"
        boolean noneMatch = employees.stream().noneMatch(employee -> employee.getName().startsWith("雷"));
        System.out.println(noneMatch);
        System.out.println();

        //findFirst()：返回第一个元素
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);
        System.out.println();

        //findAny()：返回当前流中的任意元素
        Optional<Employee> any = employees.stream().findAny();
        System.out.println(any);
    }

    @Test
    public void m2() {
        List<Employee> employees = EmployeeData.getEmployees();

        //count()：返回流中元素总数
        long count = employees.stream().filter(employee -> employee.getSalary() > 5000).count();
        System.out.println(count);
        System.out.println();

        //max(Comparator c)：返回流中最大值
        //练习：返回最高的工资
        Stream<Double> doubleStream = employees.stream().map(employee -> employee.getSalary());
        Optional<Double> max = doubleStream.max(Double::compare);
        System.out.println(max);
        System.out.println();

        //min(Comparator c)：返回流中最小值
        //练习：返回最低工资的员工
        Optional<Employee> min = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(min);
        System.out.println();

        //forEach(Consumer c)：内部迭代(使用 Collection 接口需要用户去做迭代，称为外部迭代。相反，Stream API 使用内部迭代——它帮你把迭代做了)
        employees.stream().forEach(System.out::println);

        //使用 Collection 接口需要用户去做迭代，称为外部迭代。
        employees.forEach(System.out::println);
    }

    //归约（reduce）
    @Test
    public void m3() {
        //reduce(T iden, BinaryOperator b)：可以将流中元素反复结合起来，得到一个值。返回 T
        //练习：计算1-10的自然数的和
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduceSumInteger = integers.stream().reduce(0, Integer::sum);
        System.out.println(reduceSumInteger);
        System.out.println();

        //reduce(BinaryOperator b)：可以将流中元素反复结合起来，得到一个值。返回 Optional<T>
        //l练习：计算公司所有原有员工工资的总和
        List<Employee> employees = EmployeeData.getEmployees();
        Optional<Double> reduceSumDouble = employees.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println(reduceSumDouble);

        Optional<Double> aDouble = employees.stream().map(Employee::getSalary).reduce((d1, d2) -> d1 + d2);
        System.out.println(aDouble);
    }

    //收集
    @Test
    public void m4() {
        List<Employee> employees = EmployeeData.getEmployees();

        //collect(Collector c)：将流转换为其他形式。接收一个 Collector 接口的实现，用于给Stream中元素做汇总的方法
        //练习：查找工资大于6000的员工，返回一个 List 或者一个 Set
        List<Employee> collectList = employees.stream().filter(employee -> employee.getSalary() > 6000).collect(Collectors.toList());
        collectList.forEach(System.out::println);
        System.out.println();

        Set<Employee> collectSet = employees.stream().filter(employee -> employee.getSalary() > 6000).collect(Collectors.toSet());
        collectSet.forEach(System.out::println);
    }
}








