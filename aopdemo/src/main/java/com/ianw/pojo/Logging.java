package com.ianw.pojo;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logging {

    //private static Logger logger= (Logger) LogFactory.getLog(Logging.class);

    /**
     * 声明切入点表达式
     */
    @Pointcut("execution(* com.ianw.controller.PayController.pay(int))")
    public void pointcut(){}


    /**
     * 前置通知
     */
    @Before(value = "pointcut()")
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println("前置通知");
        //获取方法的参数
        Object[] arr =joinPoint.getArgs();
        String methodName=joinPoint.getSignature().getName();
        System.out.println("---正准备执行"+methodName+"方法");
    }
    /*后置通知*/

    @After(value = "pointcut()")
    public void afterAdvice(JoinPoint joinPoint){
        System.out.println("后置通知");
        //Object[] arr =joinPoint.getArgs();
        //获得方法的名字
        String methodName=joinPoint.getSignature().getName();
        System.out.println("---已经执行"+methodName+"方法");
    }

    /**
     * 返回通知
     */
    @AfterReturning(returning = "result", value = "pointcut()")
    public void afterReturningAdvice(JoinPoint joinPoint,Object result){
        System.out.println("返回通知");
        System.out.println("Returning:" + result.toString() );
    }

    /**
     * 异常通知
     */
    @AfterThrowing(value="pointcut()",throwing="ex")
   public void afterThrowingMethod(JoinPoint joinPoint,NumberFormatException ex){

       //获得方法的名字
       String methodName=joinPoint.getSignature().getName();
       System.out.println("---执行"+methodName+"方法发生了异常");


   }



    /*环绕通知*/
    @Around(value = "pointcut()")
    public  Object  aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕通知");
        //执行目标方法
       /* try {*/
            //前置
            Object result = pjp.proceed();
            //返回
            return result ;
        /*} catch (Throwable e) {
            //异常通知
            e.printStackTrace();
        }finally {
            // 后置
        }*/

//        return null;
    }
}
