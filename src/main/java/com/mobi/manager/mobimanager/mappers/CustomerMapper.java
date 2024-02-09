package com.mobi.manager.mobimanager.mappers;

import com.mobi.manager.mobimanager.dtos.CustomerDto;
import com.mobi.manager.mobimanager.dtos.ModelDto;
import com.mobi.manager.mobimanager.entities.Customer;
import com.mobi.manager.mobimanager.entities.Model;

public class CustomerMapper {
    public static CustomerDto toDto(Customer entity) {
        return new CustomerDto(
                entity.getFirstName(),
                entity.getLastName(),
                entity.getMobileNumber(),
                entity.getLocation()
        );
    }

    public static Customer toEntity(CustomerDto dto) {
        return new Customer(
                dto.getFirstName(),
                dto.getLastName(),
                dto.getMobileNumber(),
                dto.getLocation()
        );
    }
}
