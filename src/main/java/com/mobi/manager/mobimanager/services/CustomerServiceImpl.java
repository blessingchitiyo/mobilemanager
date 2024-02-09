package com.mobi.manager.mobimanager.services;

import com.mobi.manager.mobimanager.dtos.CustomerDto;
import com.mobi.manager.mobimanager.dtos.ModelDto;
import com.mobi.manager.mobimanager.entities.Customer;
import com.mobi.manager.mobimanager.entities.Model;
import com.mobi.manager.mobimanager.mappers.CustomerMapper;
import com.mobi.manager.mobimanager.mappers.ModelMapper;
import com.mobi.manager.mobimanager.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository;
    @Override
    public CustomerDto create(CustomerDto request) {
        LocalDateTime auditTimestamp = LocalDateTime.now();

        Customer customer = new Customer();
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setMobileNumber(request.getMobileNumber());
        customer.setDateCreated(auditTimestamp);
        customer.setDateModified(auditTimestamp);

        CustomerDto response = CustomerMapper.toDto(customerRepository.save(customer));

        log.info("Customer {} created", request.getFirstName());

        return response;
    }

    @Override
    public List<CustomerDto> findAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(CustomerMapper::toDto)
                .collect(Collectors.toList());
    }
}
