package com.mobi.manager.mobimanager.services;

import com.mobi.manager.mobimanager.common.CreateStockHistoryResponse;
import com.mobi.manager.mobimanager.common.CreateStockResponse;
import com.mobi.manager.mobimanager.dtos.MainStockDto;
import com.mobi.manager.mobimanager.entities.MainStock;
import com.mobi.manager.mobimanager.entities.Model;
import com.mobi.manager.mobimanager.entities.ModelStockHistory;
import com.mobi.manager.mobimanager.exceptions.ValidationException;
import com.mobi.manager.mobimanager.repositories.ModelRepository;
import com.mobi.manager.mobimanager.repositories.StockMovementRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
@Service
@Slf4j
@AllArgsConstructor
public class StockMovementServiceImpl implements StockMovementService{

    private final ModelRepository modelRepository;

    private final StockMovementRepository stockMovementRepository;
    private static final Logger logger = LoggerFactory.getLogger(StockMovementServiceImpl.class);

    @Override
    public CreateStockHistoryResponse create(MainStockDto request) {
        logger.info("Creating new stock history{}", request);

        LocalDateTime auditTimeStamp = LocalDateTime.now();

        Optional<Model> modelById = modelRepository.findById(request.getModelId());
        if(!modelById.isPresent()) {
            throw new ValidationException(request.getModelId().toString());
        }

        ModelStockHistory mainStock = new ModelStockHistory();
        mainStock.setDateCreated(auditTimeStamp);
        mainStock.setDateModified(auditTimeStamp);
        mainStock.setQuantity(request.getQuantity());
        mainStock.setModel(modelById.get());

        ModelStockHistory savedModel = stockMovementRepository.save(mainStock);
        logger.info("Created stock history {}", savedModel);
        return new CreateStockHistoryResponse(savedModel);
    }
}
