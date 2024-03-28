package com.mobi.manager.mobimanager.dtos;

import com.mobi.manager.mobimanager.entities.Model;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SubStockDto {

    private Long customerId;
    private Double costPrice;
    private Integer quantity;
    private Long modelId;
}
