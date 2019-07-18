package com.ianw.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class CountingBeforeAdvice implements MethodBeforeAdvice {

    private int count;

    public void before(Method m, Object[] args, Object target) throws Throwable {
        System.out.println("前置通知");
        ++count;
    }

    public int getCount() {
        return count;
    }
}