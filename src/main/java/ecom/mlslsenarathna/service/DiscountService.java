package ecom.mlslsenarathna.service;

public class DiscountService {
    CustomerService customerService=new CustomerService();

    public double getDiscount(String customerMobile){
        return 0.055;
    }


}
