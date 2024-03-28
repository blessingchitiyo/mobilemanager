package com.mobi.manager.mobimanager.services;

import com.mobi.manager.mobimanager.common.CreateSupplierResponse;
import com.mobi.manager.mobimanager.dtos.SupplierDto;
import com.mobi.manager.mobimanager.entities.Supplier;

import java.util.List;

public interface SupplierService {
    CreateSupplierResponse create(SupplierDto request);

    List<Supplier> findAllSuppliers();

    List<Supplier> findSupplierById(Integer Id);
}
