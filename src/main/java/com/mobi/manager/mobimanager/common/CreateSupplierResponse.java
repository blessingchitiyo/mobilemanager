package com.mobi.manager.mobimanager.common;

import com.mobi.manager.mobimanager.entities.Supplier;
import lombok.Getter;

@Getter
public class CreateSupplierResponse {
    private final Supplier supplier;

    public CreateSupplierResponse(Supplier supplier) {
        this.supplier = supplier;
    }

}
