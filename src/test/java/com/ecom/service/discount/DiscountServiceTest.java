package com.ecom.service.discount;


import com.ecom.domain.customer.Customer;
import com.ecom.domain.customer.CustomerMembershipType;
import com.ecom.service.exceptions.UnknownMembershipException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class DiscountServiceTest {

    private IDiscountCalculatorService discountCalculatorService;

    @Before
    public void setUp() {
        discountCalculatorService = new DiscountCalculatorServiceImpl();
    }

    @Test
    public void testCalculateAmtAfterDiscountForRegular() {

        Customer regularCustomer = new Customer("John", "test@gmail.com",
                CustomerMembershipType.REGULAR);

        Assert.assertTrue(
                BigDecimal.valueOf(5000).compareTo(
                        discountCalculatorService.calculateAmtAfterDiscount(
                                regularCustomer,
                                BigDecimal.valueOf(5000)
                        )) == 0);

        Assert.assertTrue(
                BigDecimal.valueOf(9500).compareTo(
                        discountCalculatorService.calculateAmtAfterDiscount(
                                regularCustomer,
                                BigDecimal.valueOf(10000)
                        )) == 0);

        Assert.assertTrue(
                BigDecimal.valueOf(13500).compareTo(
                        discountCalculatorService.calculateAmtAfterDiscount(
                                regularCustomer,
                                BigDecimal.valueOf(15000)
                        )) == 0);
    }

    @Test
    public void testCalculateAmtAfterDiscountForPremium() {

        Customer regularCustomer = new Customer("John", "test@gmail.com",
                CustomerMembershipType.PREMIUM);

        Assert.assertTrue(
                BigDecimal.valueOf(3600).compareTo(
                        discountCalculatorService.calculateAmtAfterDiscount(
                                regularCustomer,
                                BigDecimal.valueOf(4000)
                        )) == 0);

        Assert.assertTrue(
                BigDecimal.valueOf(7000).compareTo(
                        discountCalculatorService.calculateAmtAfterDiscount(
                                regularCustomer,
                                BigDecimal.valueOf(8000)
                        )) == 0);

        Assert.assertTrue(
                BigDecimal.valueOf(10200).compareTo(
                        discountCalculatorService.calculateAmtAfterDiscount(
                                regularCustomer,
                                BigDecimal.valueOf(12000)
                        )) == 0);
        Assert.assertTrue(
                BigDecimal.valueOf(15800).compareTo(
                        discountCalculatorService.calculateAmtAfterDiscount(
                                regularCustomer,
                                BigDecimal.valueOf(20000)
                        )) == 0);

    }

    @Test(expected = UnknownMembershipException.class)
    public void testUnknownMembershipType(){
        Customer regularCustomer = new Customer("John", "test@gmail.com",
                CustomerMembershipType.GOLD);

                BigDecimal.valueOf(3600).compareTo(
                        discountCalculatorService.calculateAmtAfterDiscount(
                                regularCustomer,
                                BigDecimal.valueOf(4000)
                        ));

    }
}


