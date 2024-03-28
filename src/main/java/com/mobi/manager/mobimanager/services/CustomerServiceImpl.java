package com.mobi.manager.mobimanager.services;

import com.mobi.manager.mobimanager.common.CreateCustomerResponse;
import com.mobi.manager.mobimanager.common.CreateSupplierResponse;
import com.mobi.manager.mobimanager.dtos.CustomerDto;
import com.mobi.manager.mobimanager.dtos.ModelDto;
import com.mobi.manager.mobimanager.entities.Customer;
import com.mobi.manager.mobimanager.entities.Location;
import com.mobi.manager.mobimanager.entities.Model;
import com.mobi.manager.mobimanager.mappers.CustomerMapper;
import com.mobi.manager.mobimanager.mappers.ModelMapper;
import com.mobi.manager.mobimanager.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Override
    public CreateCustomerResponse create(CustomerDto request) {
        LocalDateTime auditTimestamp = LocalDateTime.now();

        Customer customer = new Customer();
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setMobileNumber(request.getMobileNumber());
        customer.setDateCreated(auditTimestamp);
        customer.setDateModified(auditTimestamp);

        Location location = new Location();
        location.setName(request.getLocation().getName());
        customer.setLocation(location);
        Customer savedCustomer = customerRepository.save(customer);

        log.info("Customer {} created", request.getFirstName());

        logger.info("Created customer {}", savedCustomer);
        return new CreateCustomerResponse(savedCustomer);
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();

    }

    @Override
    public void deleteById(Long Id) {
         customerRepository.deleteById(Id);
    }
}
