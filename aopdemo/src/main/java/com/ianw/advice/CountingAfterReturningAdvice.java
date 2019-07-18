package com.ianw.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class CountingAfterReturningAdvice implements AfterReturningAdvice {

    private int count;

    public void afterReturning(Object returnValue, Method m, Object[] args, Object target)
            throws Throwable {
        System.out.println("返回通知");
        System.out.println("调用方法是"+m);
        System.out.println("目标是"+target);
        ++count;
    }

    public int getCount() {
        return count;
    }
}