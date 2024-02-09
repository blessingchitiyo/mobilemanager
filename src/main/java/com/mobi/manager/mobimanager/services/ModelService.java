package com.mobi.manager.mobimanager.services;

import com.mobi.manager.mobimanager.dtos.ModelDto;

import java.util.List;

public interface ModelService {

    ModelDto create(ModelDto request);
    ModelDto findByName(String name);
    ModelDto findByModelId(Long Id);
    List<ModelDto> findAllModels();
    ModelDto deleteById(Long Id);
    ModelDto updateModels(ModelDto request);
    boolean existsByName(String name);
}
