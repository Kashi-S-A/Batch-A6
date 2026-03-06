package com.tyss.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tyss.entity.Product;
import com.tyss.repo.ProductRepository;

@Repository
public class ProductDAO {

	@Autowired
	private ProductRepository productRepository;

	public Optional<Product> findById(Integer pid) {
		return productRepository.findById(pid);
	}

	public void save(Product dbproduct) {
		productRepository.save(dbproduct);
	}

}
