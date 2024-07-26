package com.example.pr3_shopping_cart.repositories;

import com.example.pr3_shopping_cart.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
}
