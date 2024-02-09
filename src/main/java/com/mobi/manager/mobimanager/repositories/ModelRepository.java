package com.mobi.manager.mobimanager.repositories;

import com.mobi.manager.mobimanager.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {

    boolean existsByName(String name);
}
