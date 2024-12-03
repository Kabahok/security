package com.egoravdeev.cleaning_service.repositories;

import com.egoravdeev.cleaning_service.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Product, Long> {

}
