package net.gsaini092.sample1.spring.aop;

public interface CustomerBo {

    void addCustomer();
    
    void processCustomer();

    String addCustomerReturnValue();

    void addCustomerThrowException() throws Exception;

    void addCustomerAround(String name);

}
