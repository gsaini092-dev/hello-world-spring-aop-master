package net.gsaini092.sample1.spring.aop.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {
	
	@Around("execution(* net.gsaini092.sample1.spring.aop.CustomerBo.addCustomerAround(..))")
    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {

	 	System.out.println("logAround() is running!");
	 	System.out.println("hijacked method : " + joinPoint.getSignature().getName());
	 	System.out.println("hijacked arguments : " + Arrays.toString(joinPoint.getArgs()));
	 		
	 	System.out.println("Around before is running!");
	 	joinPoint.proceed(); //continue on the intercepted method
	 	System.out.println("Around after is running!");
	 		
	 	System.out.println("******");

    }

    @Before("execution(* net.gsaini092.sample1.spring.aop.CustomerBo.addCustomer(..))")
    public void logBefore(JoinPoint joinPoint) {

        System.out.println("logBefore() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("******");
    }
    
    @After("execution(* net.gsaini092.sample1.spring.aop.CustomerBo.processCustomer(..))")
	public void logAfter(JoinPoint joinPoint) {

		System.out.println("logAfter() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("******");

	}

    @AfterReturning(
            pointcut = "execution(* net.gsaini092.sample1.spring.aop.CustomerBo.addCustomerReturnValue(..))",
            returning= "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {

        System.out.println("logAfterReturning() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("Method returned value is : " + result);
        System.out.println("******");

    }

    @AfterThrowing(
            pointcut = "execution(* net.gsaini092.sample1.spring.aop.CustomerBo.addCustomerThrowException(..))",
            throwing= "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {

        System.out.println("logAfterThrowing() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("Exception : " + error);
        System.out.println("******");

    }
    
    

}