package com.ecom.domain.customer;

/**
 * Domain class representing customer
 */
public class Customer {

    final private String firstName;
    final private String email;
    final private CustomerMembershipType customerMembershipType;

    public Customer(String firstName, String email, CustomerMembershipType customerMembershipType) {
        this.firstName = firstName;
        this.email = email;
        this.customerMembershipType = customerMembershipType;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public CustomerMembershipType getCustomerMembershipType() {
        return customerMembershipType;
    }
}