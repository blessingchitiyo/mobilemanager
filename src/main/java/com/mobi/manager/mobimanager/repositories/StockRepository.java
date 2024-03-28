package com.mobi.manager.mobimanager.repositories;

import com.mobi.manager.mobimanager.entities.MainStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface StockRepository extends JpaRepository<MainStock,Long> {

    MainStock findByModelId(@Param("modelId") Long modelId);
}
