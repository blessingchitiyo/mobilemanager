package com.mobi.manager.mobimanager.controllers;

import com.mobi.manager.mobimanager.dtos.CustomerDto;
import com.mobi.manager.mobimanager.dtos.ModelDto;
import com.mobi.manager.mobimanager.exceptions.errors.ModelNotFoundException;
import com.mobi.manager.mobimanager.services.CustomerService;
import com.mobi.manager.mobimanager.services.ModelService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/customers/")

@Slf4j
@Tag(name = "Customer API Version 1",
        description = "This api is used to manage customers.")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<CustomerDto> create(@RequestBody CustomerDto request) {
        return new ResponseEntity<>(customerService.create(request), HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<CustomerDto>> findAllCustomers() {
        List<CustomerDto> response = customerService.findAllCustomers();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
