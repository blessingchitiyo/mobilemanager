package com.mobi.manager.mobimanager.controllers;

import com.mobi.manager.mobimanager.common.CreateSupplierResponse;
import com.mobi.manager.mobimanager.dtos.CustomerDto;
import com.mobi.manager.mobimanager.dtos.SupplierDto;
import com.mobi.manager.mobimanager.entities.Supplier;
import com.mobi.manager.mobimanager.services.SupplierService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/suppliers/")

@Slf4j
@Tag(name = "Suppliers API Version 1",
        description = "This api is used to manage suppliers.")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<CreateSupplierResponse> create(@RequestBody SupplierDto request) {
        return new ResponseEntity<>(supplierService.create(request), HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Supplier>> findAll() {
        List<Supplier> response = supplierService.findAllSuppliers();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
