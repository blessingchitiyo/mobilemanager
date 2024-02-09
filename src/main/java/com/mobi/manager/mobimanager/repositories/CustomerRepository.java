package com.mobi.manager.mobimanager.repositories;

import com.mobi.manager.mobimanager.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
