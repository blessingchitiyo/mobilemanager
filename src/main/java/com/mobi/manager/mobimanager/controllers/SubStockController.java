package com.mobi.manager.mobimanager.controllers;

import com.mobi.manager.mobimanager.common.CreateStockResponse;
import com.mobi.manager.mobimanager.dtos.MainStockDto;
import com.mobi.manager.mobimanager.dtos.SubStockDto;
import com.mobi.manager.mobimanager.entities.MainStock;
import com.mobi.manager.mobimanager.entities.SubStock;
import com.mobi.manager.mobimanager.repositories.SubStockRepository;
import com.mobi.manager.mobimanager.services.SubStockService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/substock/")

@Slf4j
@Tag(name = "Sub Stock API Version 1",
        description = "This api is used to manage Sub Stocks.")
public class SubStockController {

    @Autowired
    private final SubStockRepository stockRepository;

    @Autowired
    private final SubStockService stockService;

    public SubStockController(SubStockRepository stockRepository, SubStockService stockService) {
        this.stockRepository = stockRepository;
        this.stockService = stockService;
    }

    @GetMapping(path = "/{modelId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<SubStock> findModelById(@PathVariable("modelId") Long modelId) {
        SubStock response = stockRepository.findByModelId(modelId);
        return ResponseEntity.ok(response);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<SubStock> create(@RequestBody SubStockDto request) {
        return new ResponseEntity<>(stockService.create(request), HttpStatus.CREATED);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Collection<SubStock>> findAll() {
        Collection<SubStock> response = stockService.findAllStocks();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
