package com.mobi.manager.mobimanager.services;

import com.mobi.manager.mobimanager.dtos.CustomerDto;
import com.mobi.manager.mobimanager.dtos.ModelDto;

import java.util.List;

public interface CustomerService{
    CustomerDto create(CustomerDto request);
    List<CustomerDto> findAllCustomers();
}
