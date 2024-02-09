package com.mobi.manager.mobimanager.mappers;

import com.mobi.manager.mobimanager.dtos.ModelDto;
import com.mobi.manager.mobimanager.entities.Model;

public class ModelMapper {
    public static ModelDto toDto(Model entity) {
        return new ModelDto(
                entity.getName(),
                entity.getPrice()
        );
    }

    public static Model toEntity(ModelDto dto) {
        return new Model(
                dto.getName(),
                dto.getPrice()
        );
    }
}
