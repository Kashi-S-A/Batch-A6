package com.tyss.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tyss.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	// Custom queries
//	@Query("SELECT p FROM Product p WHERE p.category=?1")
	@Query("SELECT p FROM Product p WHERE p.category=:category")
	public List<Product> getProductByCategory(String category);

	@Query("SELECT p FROM Product p WHERE p.price>?1 AND p.price<?2")
	public List<Product> getProductByRange(Double fromPrice, Double toPrice);

	// custom methods --> method name should start from findByPropertiesOfEntity

	public List<Product> findByCategory(String category);

	List<Product> findByPriceBetween(Double from, Double to);

	List<Product> findByPriceAndBrand(Double price, String brand);

	List<Product> findByPriceGreaterThan(Double price);

}