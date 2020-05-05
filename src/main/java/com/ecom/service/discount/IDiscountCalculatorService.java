package com.ecom.service.discount;

import com.ecom.domain.customer.Customer;

import java.math.BigDecimal;

/**
 * Convenience interface for discount calculation implementations
 */
public interface IDiscountCalculatorService {

    /***
     * Calculates the discount amount for purchaseAmt based on the {@link com.ecom.domain.customer.CustomerMembershipType}
     * @param customer
     * @param purchaseAmt
     * @return {@code BigDecimal}
     */
    BigDecimal calculateDiscount(Customer customer, BigDecimal purchaseAmt);

    /***
     * Calculates the total amount after discount application on purchaseAmt based on the slabs of {@link com.ecom.domain.customer.CustomerMembershipType}
     * @param customer
     * @param purchaseAmt
     * @return @return {@code BigDecimal}
     */
    BigDecimal calculateAmtAfterDiscount(Customer customer, BigDecimal purchaseAmt);
}
