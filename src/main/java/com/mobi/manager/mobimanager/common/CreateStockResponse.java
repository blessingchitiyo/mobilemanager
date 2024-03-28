package com.mobi.manager.mobimanager.common;

import com.mobi.manager.mobimanager.entities.MainStock;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateStockResponse {
    private final MainStock mainStock;
}
