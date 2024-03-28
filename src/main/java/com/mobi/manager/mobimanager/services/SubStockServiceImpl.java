package com.mobi.manager.mobimanager.services;

import com.mobi.manager.mobimanager.dtos.SubStockDto;
import com.mobi.manager.mobimanager.entities.Customer;
import com.mobi.manager.mobimanager.entities.MainStock;
import com.mobi.manager.mobimanager.entities.Model;
import com.mobi.manager.mobimanager.entities.SubStock;
import com.mobi.manager.mobimanager.exceptions.ValidationException;
import com.mobi.manager.mobimanager.repositories.CustomerRepository;
import com.mobi.manager.mobimanager.repositories.ModelRepository;
import com.mobi.manager.mobimanager.repositories.StockRepository;
import com.mobi.manager.mobimanager.repositories.SubStockRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class SubStockServiceImpl implements SubStockService {

    private final SubStockRepository subStockRepository;

    private final CustomerRepository customerRepository;

    private final ModelRepository modelRepository;

    private final StockRepository stockRepository;

    private static final Logger logger = LoggerFactory.getLogger(SubStockServiceImpl.class);

    @Override
    @Transactional
    public SubStock create(SubStockDto request) {
        //Check if customer exist
        //Check if model exist
        //Verify Quantity requested is available in MainStock
        //Subtract quantity from MainStock on condition of availability

        logger.info("Creating new sub stock{}", request);

        LocalDateTime auditTimeStamp = LocalDateTime.now();

        Optional<Model> modelOptional = modelRepository.findById(request.getModelId());
        if (!modelOptional.isPresent()) {
            throw new ValidationException(request.getModelId().toString());
        }

        Optional<Customer> customerOptional = customerRepository.findById(request.getCustomerId());
        if (!customerOptional.isPresent()) {
            throw new ValidationException(request.getModelId().toString());
        }

        MainStock mainStockOptional = stockRepository.findByModelId(request.getModelId());
        if (!(mainStockOptional.getQuantity() >= request.getQuantity())) {
            throw new ValidationException("Available quantity less than requested");
        } else {
            //Subtract from MainStock
            mainStockOptional.setQuantity(mainStockOptional.getQuantity() - request.getQuantity());
            stockRepository.save(mainStockOptional);
        }

        SubStock stock = new SubStock();
        stock.setCostPrice(request.getCostPrice());
        stock.setModel(modelOptional.get());
        stock.setQuantity(request.getQuantity());
        stock.setCustomer(customerOptional.get());
        stock.setDateCreated(auditTimeStamp);
        stock.setDateModified(auditTimeStamp);

        SubStock savedModel = subStockRepository.save(stock);
        logger.info("Creating new sub stock{}", savedModel);
        return savedModel;
    }

    @Override
    public Collection<SubStock> findAllStocks() {
        return subStockRepository.findAll();
    }

    @Override
    public SubStock findByModelId(Long modelId) {
        return subStockRepository.findByModelId(modelId);
    }

    @Override
    public SubStock findByCustomerId(Long customerId) {
        return null;
    }

}
