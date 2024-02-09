package com.mobi.manager.mobimanager.dtos;

import com.mobi.manager.mobimanager.entities.Location;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierDto {

    private String supplier_name;
    private String mobileNumber;
    private LocationDto location;
}
