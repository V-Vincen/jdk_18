package com.example.jdk_18.stream_api;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//提供用于测试的数据
public class EmployeeData {

    public static List<Employee> getEmployees(){
        List<Employee> list = new ArrayList<>();

        list.add(new Employee(1001,"马化腾",34,6000.38));
        list.add(new Employee(1002,"马云",12,9876.12));
        list.add(new Employee(1003,"刘强东",33,3000.82));
        list.add(new Employee(1004,"雷军",26,7657.37));
        list.add(new Employee(1005,"李彦宏",65,5555.32));
        list.add(new Employee(1006,"比尔盖茨",42,9500.43));
        list.add(new Employee(1007,"任正非",26,4333.32));
        list.add(new Employee(1008,"扎克伯格",35,2500.32));

        return list;
    }

}

class Employee{
    private Integer id;
    private String name;
    private Integer age;
    private Double salary;

    public Employee(Integer id, String name, Integer age, Double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Employee(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
                Objects.equals(name, employee.name) &&
                Objects.equals(age, employee.age) &&
                Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}