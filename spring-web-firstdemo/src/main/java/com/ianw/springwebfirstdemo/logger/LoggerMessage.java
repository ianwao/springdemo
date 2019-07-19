package com.ianw.springwebfirstdemo.logger;


import com.ianw.springwebfirstdemo.comtroller.HelloWorldController;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerMessage {
    private final static Logger LOGGER = LoggerFactory.getLogger(HelloWorldController.class);


    @Pointcut("execution(* com.ianw.springwebfirstdemo.comtroller.HelloWorldController.*(..))")
    public void pointcut(){

    }

    @Before(value = "pointcut()")
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println("日志记录开始");
        //获取方法的参数
        Object[] arr =joinPoint.getArgs();
        String methodName=joinPoint.getSignature().getName();
        System.out.println("---正准备执行"+methodName+"方法");
    }

    @After(value = "pointcut()")
    public void afterAdvice(JoinPoint joinPoint){
        System.out.println("日志记录结束");
        //Object[] arr =joinPoint.getArgs();
        //获得方法的名字
        String methodName=joinPoint.getSignature().getName();
        System.out.println("---已经执行"+methodName+"方法");
    }

    @AfterReturning(returning = "result", value = "pointcut()")
    public void afterReturningAdvice(JoinPoint joinPoint,Object result){
        System.out.println("返回值:" + result.toString() );
    }

    @AfterThrowing(value="pointcut()",throwing="ex")
    public void afterThrowingMethod(JoinPoint joinPoint,NumberFormatException ex){
        //获得方法的名字
        String methodName=joinPoint.getSignature().getName();
        System.out.println("---执行"+methodName+"方法发生了异常，异常原因是"+ex);
    }

}
