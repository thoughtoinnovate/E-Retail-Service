package com.ecom.service.discount;

import com.ecom.domain.customer.Customer;
import com.ecom.service.exceptions.DiscountServiceException;
import com.ecom.service.slabs.ISlabService;
import com.ecom.service.slabs.SlabServiceImpl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.TreeMap;

/**
 * Service class implementation of {@link IDiscountCalculatorService}
 * Contains convenience methods for discount calculation
 */
public class DiscountCalculatorServiceImpl implements IDiscountCalculatorService {

    private ISlabService slabService = new SlabServiceImpl();

    @Override
    public BigDecimal calculateDiscount(Customer customer, BigDecimal purchaseAmt) {

        if (null == customer || null == customer.getCustomerMembershipType() || null == purchaseAmt) {
            throw new DiscountServiceException("Attributes not valid!");
        }

        TreeMap<BigDecimal, Float> slabs = slabService.retrieveSlabs(customer);
        BigDecimal totalDiscountAmt = BigDecimal.ZERO;
        BigDecimal previousDiscountSlab = BigDecimal.ZERO;

        //Iterate available slabs till purchase amount could be applied
        for (Map.Entry<BigDecimal, Float> slab : slabs.entrySet()) {

            if (purchaseAmt.compareTo(slab.getKey()) > 0) {

                final BigDecimal discount = slab.getKey().subtract(previousDiscountSlab)
                        .multiply(BigDecimal.valueOf(slab.getValue()))
                        .divide(BigDecimal.valueOf(100))
                        .setScale(1, RoundingMode.HALF_UP);

                previousDiscountSlab = slab.getKey();
                totalDiscountAmt = totalDiscountAmt.add(discount);

            } else {

                final BigDecimal discount = purchaseAmt.subtract(previousDiscountSlab)
                        .multiply(BigDecimal.valueOf(slab.getValue()))
                        .divide(BigDecimal.valueOf(100))
                        .setScale(1, RoundingMode.HALF_UP);

                previousDiscountSlab = slab.getKey();
                totalDiscountAmt = totalDiscountAmt.add(discount);
                break;
            }
        }

        return totalDiscountAmt;

    }

    @Override
    public BigDecimal calculateAmtAfterDiscount(Customer customer, BigDecimal purchaseAmt) {

        if (null == customer || null == customer.getCustomerMembershipType() || null == purchaseAmt) {
            throw new DiscountServiceException("Attributes not valid");
        }

        BigDecimal discount = calculateDiscount(customer, purchaseAmt);

        return purchaseAmt.subtract(discount);

    }
}
