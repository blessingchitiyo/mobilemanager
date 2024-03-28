package com.mobi.manager.mobimanager.repositories;

import com.mobi.manager.mobimanager.entities.ModelStockHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockMovementRepository extends JpaRepository<ModelStockHistory,Long> {

}
