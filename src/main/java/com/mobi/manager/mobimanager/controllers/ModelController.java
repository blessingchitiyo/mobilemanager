package com.mobi.manager.mobimanager.controllers;

import com.mobi.manager.mobimanager.dtos.ModelDto;
import com.mobi.manager.mobimanager.entities.Model;
import com.mobi.manager.mobimanager.exceptions.ApiExceptionHandler;
import com.mobi.manager.mobimanager.exceptions.errors.ModelNotFoundException;
import com.mobi.manager.mobimanager.services.ModelService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/model/")

@Slf4j
@Tag(name = "Phone Models API Version 1",
        description = "This api is used to manage Cellphone models.")
public class ModelController {
    @Autowired
    private ModelService modelService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Model> create(@RequestBody ModelDto createModelRequest) {
        Model model = modelService.create(createModelRequest);
        return new ResponseEntity<>(model, HttpStatus.CREATED);
    }

    @GetMapping("{Id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Model> findByModelId(@PathVariable("Id") Long Id) {
        Model response = modelService.findByModelId(Id);
        if (response == null)
            throw new ModelNotFoundException("Model not found");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Model>> findAllModels() {
        List<Model> response = modelService.findAllModels();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
