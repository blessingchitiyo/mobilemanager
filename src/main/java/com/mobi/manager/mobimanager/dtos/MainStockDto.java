package com.mobi.manager.mobimanager.dtos;

import com.mobi.manager.mobimanager.entities.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainStockDto {
    private Integer quantity;
    private Long modelId;
}
