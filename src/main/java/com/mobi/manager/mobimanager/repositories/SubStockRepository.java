package com.mobi.manager.mobimanager.repositories;

import com.mobi.manager.mobimanager.entities.SubStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubStockRepository extends JpaRepository<SubStock, Long> {
    SubStock findByModelId(Long modelId);
}
