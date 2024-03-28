package com.mobi.manager.mobimanager.services;

import com.mobi.manager.mobimanager.common.CreateSupplierResponse;
import com.mobi.manager.mobimanager.dtos.SupplierDto;
import com.mobi.manager.mobimanager.entities.Customer;
import com.mobi.manager.mobimanager.entities.Location;
import com.mobi.manager.mobimanager.entities.Supplier;
import com.mobi.manager.mobimanager.exceptions.ValidationException;
import com.mobi.manager.mobimanager.mappers.CustomerMapper;
import com.mobi.manager.mobimanager.repositories.SupplierRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    private static final Logger logger = LoggerFactory.getLogger(SupplierServiceImpl.class);

    @Override
    public CreateSupplierResponse create(SupplierDto request) {

        logger.info("Creating supplier {}", request);
        validateRequest(request);
        LocalDateTime auditTimeStamp = LocalDateTime.now();

        Supplier supplier = new Supplier();
        supplier.setDateCreated(auditTimeStamp);
        supplier.setDateModified(auditTimeStamp);
        supplier.setSupplierName(request.getSupplierName());

        Location location = new Location();
        location.setName(request.getLocation().getName());

        supplier.setLocation(location);
        supplier.setMobileNumber(request.getMobileNumber());
        Supplier savedCustomer = supplierRepository.save(supplier);
        logger.info("Created supplier {}", savedCustomer);
        return new CreateSupplierResponse(savedCustomer);
    }

    @Override
    public List<Supplier> findAllSuppliers() {

        return supplierRepository.findAll();
    }

    @Override
    public List<Supplier> findSupplierById(Integer Id) {
        return null;
    }

    private void validateRequest(SupplierDto request) {
        if (!StringUtils.hasText(request.getSupplierName())) {
            throw new ValidationException("Supplier name is required");
        }
        if (!StringUtils.hasText(request.getMobileNumber())) {
            throw new ValidationException("Mobile number is required");
        }
        if (!StringUtils.hasText(request.getLocation().getName())) {
            throw new ValidationException("Location is required");
        }
    }
}
