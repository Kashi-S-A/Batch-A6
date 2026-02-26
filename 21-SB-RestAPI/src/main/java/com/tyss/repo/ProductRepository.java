package com.tyss.repo;

import org.springframework.data.repository.CrudRepository;

import com.tyss.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
