package com.example.jdk_18.functional_interfaces;


//自定义函数式接口
@FunctionalInterface
public interface MyFunction<T> {
    public T getValue(T t);
}
