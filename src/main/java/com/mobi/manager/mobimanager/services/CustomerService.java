package com.mobi.manager.mobimanager.services;

import com.mobi.manager.mobimanager.common.CreateCustomerResponse;
import com.mobi.manager.mobimanager.dtos.CustomerDto;
import com.mobi.manager.mobimanager.dtos.ModelDto;
import com.mobi.manager.mobimanager.entities.Customer;

import java.util.List;

public interface CustomerService{
    CreateCustomerResponse create(CustomerDto request);
    List<Customer> findAllCustomers();
    void deleteById(Long Id);
}
