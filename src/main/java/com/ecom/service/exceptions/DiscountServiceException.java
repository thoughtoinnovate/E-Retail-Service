package com.ecom.service.exceptions;

/**
 * Exception class for any run time errors in {@link com.ecom.service.discount.IDiscountCalculatorService} implementations
 */
public class DiscountServiceException extends RuntimeException {

    /***
     *
     * @param msg
     */
    public DiscountServiceException(String msg) {
    }
}
