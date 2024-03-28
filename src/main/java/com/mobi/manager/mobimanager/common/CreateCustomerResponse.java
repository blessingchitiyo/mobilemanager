package com.mobi.manager.mobimanager.common;

import com.mobi.manager.mobimanager.entities.Customer;
import lombok.Getter;

@Getter
public class CreateCustomerResponse {
    private final Customer customer;

    public CreateCustomerResponse(Customer customer) {
        this.customer = customer;
    }
}
