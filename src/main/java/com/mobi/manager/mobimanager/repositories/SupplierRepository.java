package com.mobi.manager.mobimanager.repositories;

import com.mobi.manager.mobimanager.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Long> {
}
