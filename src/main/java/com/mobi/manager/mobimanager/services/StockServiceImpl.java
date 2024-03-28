package com.mobi.manager.mobimanager.services;

import com.mobi.manager.mobimanager.common.CreateStockResponse;
import com.mobi.manager.mobimanager.dtos.MainStockDto;
import com.mobi.manager.mobimanager.entities.MainStock;
import com.mobi.manager.mobimanager.entities.Model;
import com.mobi.manager.mobimanager.exceptions.ValidationException;
import com.mobi.manager.mobimanager.repositories.ModelRepository;
import com.mobi.manager.mobimanager.repositories.StockRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;

    private final ModelRepository modelRepository;

    @Autowired
    private final StockMovementService stockMovementService;

    private static final Logger logger = LoggerFactory.getLogger(StockServiceImpl.class);


    @Override
    public MainStock findModelById(Long modelId) {
        return stockRepository.findByModelId(modelId);
    }

    @Override
    public List<MainStock> findAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public CreateStockResponse create(MainStockDto request) {
        //create new record if model doesn't exist in db
        //increment quantity if model exist
        //Also add to history table for audit

        logger.info("Creating new stock {}", request);
        validateRequest(request);
        LocalDateTime auditTimeStamp = LocalDateTime.now();

        Optional<Model> modelById = modelRepository.findById(request.getModelId());
        if (!modelById.isPresent()) {
            throw new ValidationException(request.getModelId().toString());
        }

        //If model exist in stock then increment else add new record
        Optional<MainStock> stockExist = stockRepository.findById(request.getModelId());
        if (stockExist.isPresent()) {
            //Increment by updating
            //Update stock history
            stockMovementService.create(request);
            return update(request);
        } else {
            //Create new
            MainStock mainStock = new MainStock();
            mainStock.setDateCreated(auditTimeStamp);
            mainStock.setDateModified(auditTimeStamp);
            mainStock.setQuantity(request.getQuantity());
            mainStock.setModel(modelById.get());

            MainStock savedModel = stockRepository.save(mainStock);
            logger.info("Created model {}", savedModel);
            //Update stock history
            stockMovementService.create(request);
            return new CreateStockResponse(savedModel);
        }

    }

    @Override
    public CreateStockResponse update(MainStockDto request) {
        final MainStock mainStock = findModelById(request.getModelId());
        mainStock.setQuantity(mainStock.getQuantity() + request.getQuantity());

        return new CreateStockResponse(stockRepository.save(mainStock));
    }

    private void validateRequest(MainStockDto request) {
        if (request.getModelId() == null) {
            throw new ValidationException("Model is required");
        }
        if (!StringUtils.hasText(request.getQuantity().toString())) {
            throw new ValidationException("Quantity is required");
        }
    }
}
