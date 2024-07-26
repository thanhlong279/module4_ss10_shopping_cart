package com.example.pr3_shopping_cart.services;

import com.example.pr3_shopping_cart.models.Product;
import com.example.pr3_shopping_cart.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepository.getReferenceById(productId);
    }
}
