package com.ecom.service.slabs;

import com.ecom.domain.customer.Customer;

import java.math.BigDecimal;
import java.util.TreeMap;

/**
 * Convenience service interface for the fetching the available slabs based on the {@link com.ecom.domain.customer.CustomerMembershipType}
 */
public interface ISlabService {
    /**
     * Retrieve discount slabs from external system or as configured based on customer attributes
     *
     * @param customer
     * @return {@code TreeMap<BigDecimal,Float>}
     */
    TreeMap<BigDecimal, Float> retrieveSlabs(Customer customer);
}
