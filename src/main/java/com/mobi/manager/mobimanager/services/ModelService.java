package com.mobi.manager.mobimanager.services;

import com.mobi.manager.mobimanager.dtos.ModelDto;
import com.mobi.manager.mobimanager.entities.Model;

import java.util.List;

public interface ModelService {

    Model create(ModelDto request);
    Model findByName(String name);
    Model findByModelId(Long Id);
    List<Model> findAllModels();
    Model deleteById(Long Id);
    ModelDto updateModels(ModelDto request);
    boolean existsByName(String name);
}
