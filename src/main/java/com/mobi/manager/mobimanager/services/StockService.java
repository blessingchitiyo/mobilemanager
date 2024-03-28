package com.mobi.manager.mobimanager.services;

import com.mobi.manager.mobimanager.common.CreateStockResponse;
import com.mobi.manager.mobimanager.dtos.MainStockDto;
import com.mobi.manager.mobimanager.entities.MainStock;

import java.util.List;
import java.util.Optional;

public interface StockService {
    MainStock findModelById(Long modelId);

    List<MainStock> findAllStocks();

    CreateStockResponse create(MainStockDto request);

    CreateStockResponse update(MainStockDto request);
}
