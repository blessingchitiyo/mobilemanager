package com.mobi.manager.mobimanager.services;

import com.mobi.manager.mobimanager.dtos.SubStockDto;
import com.mobi.manager.mobimanager.entities.SubStock;

import java.util.Collection;

public interface SubStockService {
    SubStock create(SubStockDto request);
    Collection<SubStock> findAllStocks();
    SubStock findByModelId(Long modelId);
    SubStock findByCustomerId(Long customerId);
}
