package com.ianw.advice;

import org.springframework.aop.ThrowsAdvice;

import java.rmi.RemoteException;

public class RemoteThrowsAdvice implements ThrowsAdvice {

    public void afterThrowing(RemoteException ex) throws Throwable {
        // Do something with remote exception
        System.out.println("异常通知");
    }
}