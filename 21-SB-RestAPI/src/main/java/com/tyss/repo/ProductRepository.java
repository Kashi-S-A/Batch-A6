package com.tyss.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}