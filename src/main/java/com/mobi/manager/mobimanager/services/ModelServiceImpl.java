package com.mobi.manager.mobimanager.services;

import com.mobi.manager.mobimanager.dtos.ModelDto;
import com.mobi.manager.mobimanager.entities.Model;
import com.mobi.manager.mobimanager.exceptions.errors.ModelNotFoundException;
import com.mobi.manager.mobimanager.mappers.ModelMapper;
import com.mobi.manager.mobimanager.repositories.ModelRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;

    @Override
    @Transactional
    public Model create(ModelDto request) {

        //Check for existence of model
        if (existsByName(request.getName()))
            throw new ModelNotFoundException("Model already exist in the system");

        LocalDateTime auditTimestamp = LocalDateTime.now();

        Model model = new Model();
        model.setName(request.getName());
        model.setDateCreated(auditTimestamp);
        model.setDateModified(auditTimestamp);
        model.setPrice(request.getPrice());
        Model modelSaved = modelRepository.save(model);

        ModelDto response = ModelMapper.toDto(modelSaved);

        log.info("Model {} created", request.getName());

        return model;
    }

    @Override
    public Model findByName(String name) {
        return null;
    }

    public Model findByModelId(Long Id) {
        Optional<Model> optModel = modelRepository.findById(Id);
       return optModel.get();
        //return ModelMapper.toDto(model);
    }

    @Override
    public List<Model> findAllModels() {
       return modelRepository.findAll();
    }

    @Override
    public Model deleteById(Long Id) {
        return null;
    }

    @Override
    public ModelDto updateModels(ModelDto request) {
        return null;
    }

    @Override
    public boolean existsByName(String name) {
        return modelRepository.existsByName(name);
    }

}
