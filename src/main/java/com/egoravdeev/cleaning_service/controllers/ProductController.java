package com.egoravdeev.cleaning_service.controllers;

import com.egoravdeev.cleaning_service.model.Product;
import com.egoravdeev.cleaning_service.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Data
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/createProduct")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

}
