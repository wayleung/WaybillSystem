package com.way.waybillsystem.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Repository;

/** 
 * 把这个类声明为一个切面： 
 * 1. 使用注解“@Repository”把该类放入到IOC容器中 
 * 2. 使用注解“@Aspect”把该类声明为一个切面 
 *  
 * 设置切面的优先级: 
 * 3. 使用注解“@Order(number)”指定前面的优先级，值越小，优先级越高 
 */  
/*@Order(1)  */
/*@Aspect  */
/*@Repository*/
public class DaoLogAspect {  
    /** 
     * 声明该方法是一个前置通知:在目标方法开始之前执行 
     * '@Before'标识这个方法是个前置通知,切点表达式表示执行 UserDao类的 insert(User user) 方法. 
     * execution(* com.way.waybillsystem.serviceImpl.*.*(..))
     */  
	
    @Before("execution(* com.way.waybillsystem.serviceImpl.*.*(..))") 
    public void beforeMethod()  
    {  
        System.out.println("--beforeMethod------------");  
    }  
}  