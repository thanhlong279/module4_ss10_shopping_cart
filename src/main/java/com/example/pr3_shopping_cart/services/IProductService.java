package com.example.pr3_shopping_cart.services;

import com.example.pr3_shopping_cart.models.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();

    Product findProduct(Long id);

    Optional<Product> findById(Long id);

    Product getProductById(Long productId);
}
