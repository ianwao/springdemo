package com.ianw.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
public class Logging {

    private int order;


    /**
     * 前置通知
     */
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println("前置通知");
        //获取方法的参数
        Object[] arr =joinPoint.getArgs();
        String methodName=joinPoint.getSignature().getName();
    }

    /*后置通知*/
    public void afterAdvice(JoinPoint joinPoint){
        System.out.println("后置通知");
        //Object[] arr =joinPoint.getArgs();
        //获得方法的名字
        String methodName=joinPoint.getSignature().getName();
    }

    /**
     * 返回通知
     */
    public void afterReturningAdvice(JoinPoint joinPoint,Object result){
        System.out.println("返回通知");
    }

    /**
     * 异常通知
     */
   public void afterThrowingMethod(JoinPoint joinPoint,NumberFormatException ex){
       //获得方法的名字
       String methodName=joinPoint.getSignature().getName();
       System.out.println("---执行"+methodName+"方法发生了异常");
   }


    /*环绕通知*/
    public Object  aroundMethod(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("进入环绕通知");

        Object result = pjp.proceed();

        System.out.println("退出环绕通知");

        return result;

    }
}
