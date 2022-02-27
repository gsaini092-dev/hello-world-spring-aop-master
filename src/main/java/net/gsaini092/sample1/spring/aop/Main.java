package net.gsaini092.sample1.spring.aop;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

        public static void main(String[] args) throws Exception {

            ApplicationContext appContext = new ClassPathXmlApplicationContext("spring-sample1.xml");
            CustomerBo customer = (CustomerBo) appContext.getBean("customerBo");
            
            System.out.println("-------- Aspect @Around");
            customer.addCustomerAround("Venu");
            
            System.out.println("-------- Aspect @Before");
            customer.addCustomer();
            
            System.out.println("-------- Aspect @After");
            customer.processCustomer();

            System.out.println("-------- Aspect @AfterReturning");
            System.out.println("Value returned --> " + customer.addCustomerReturnValue());

            System.out.println("-------- Aspect @AfterThrowing");
            customer.addCustomerThrowException();

        }
}
