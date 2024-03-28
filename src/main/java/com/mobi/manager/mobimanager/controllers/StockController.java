package com.mobi.manager.mobimanager.controllers;

import com.mobi.manager.mobimanager.common.CreateStockResponse;
import com.mobi.manager.mobimanager.common.CreateSupplierResponse;
import com.mobi.manager.mobimanager.dtos.MainStockDto;
import com.mobi.manager.mobimanager.dtos.SupplierDto;
import com.mobi.manager.mobimanager.entities.MainStock;
import com.mobi.manager.mobimanager.services.StockMovementService;
import com.mobi.manager.mobimanager.services.StockService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/stock/")

@Slf4j
@Tag(name = "Stocks API Version 1",
        description = "This api is used to manage Main Stocks.")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping(path = "/{modelId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<MainStock> findById(@PathVariable("modelId") Long modelId) {
        MainStock response = stockService.findModelById(modelId);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<CreateStockResponse> create(@RequestBody MainStockDto request) {
        return new ResponseEntity<>(stockService.create(request), HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<MainStock>> findAllStocks() {
        List<MainStock> response = stockService.findAllStocks();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
