package com.mobi.manager.mobimanager.dtos;

import com.mobi.manager.mobimanager.entities.Location;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private String firstName;

    private String lastName;

    private String mobileNumber;

    private Location location;

}
