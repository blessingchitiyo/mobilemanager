package com.mobi.manager.mobimanager.services;

import com.mobi.manager.mobimanager.common.CreateStockHistoryResponse;
import com.mobi.manager.mobimanager.common.CreateStockResponse;
import com.mobi.manager.mobimanager.dtos.MainStockDto;

public interface StockMovementService {
    CreateStockHistoryResponse create(MainStockDto request);
}
