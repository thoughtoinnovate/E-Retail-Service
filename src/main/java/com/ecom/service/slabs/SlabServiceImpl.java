package com.ecom.service.slabs;

import com.ecom.domain.customer.Customer;
import com.ecom.service.exceptions.UnknownMembershipException;

import java.math.BigDecimal;
import java.util.TreeMap;

/**
 * Implementation of {@link ISlabService}
 */
public class SlabServiceImpl implements ISlabService {

    //mocking calls representing a DB or Service call for feting slab values.
    @Override
    public TreeMap<BigDecimal, Float> retrieveSlabs(Customer customer) {

        TreeMap<BigDecimal, Float> slab = new TreeMap<>();

        switch (customer.getCustomerMembershipType()) {

            case PREMIUM:
                slab.put(BigDecimal.valueOf(4000), Float.valueOf(10));
                slab.put(BigDecimal.valueOf(8000), Float.valueOf(15));
                slab.put(BigDecimal.valueOf(12000), Float.valueOf(20));
                slab.put(BigDecimal.valueOf(Integer.MAX_VALUE), Float.valueOf(30));
                break;
            case REGULAR:
                slab.put(BigDecimal.valueOf(5000), Float.valueOf(0));
                slab.put(BigDecimal.valueOf(10000), Float.valueOf(10));
                slab.put(BigDecimal.valueOf(Integer.MAX_VALUE), Float.valueOf(20));
                break;
            default:
                throw new UnknownMembershipException(customer.getCustomerMembershipType() + " not supported!");
        }

        return slab;
    }
}
