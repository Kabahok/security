package com.egoravdeev.cleaning_service.service;

import com.egoravdeev.cleaning_service.repositories.ServiceRepository;
import lombok.Data;
import com.egoravdeev.cleaning_service.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class ProductService {
    private final ServiceRepository serviceRepository;

    public List<Product> getAllProducts() {
        return serviceRepository.findAll();
    }

    public void addProduct(Product product) {
        serviceRepository.save(product);
    }
}
