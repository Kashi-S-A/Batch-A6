package com.tyss.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.dao.ProductDAO;
import com.tyss.entity.Product;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO productDAO;

	public String updateProduct(Integer pid,Product product) {
		Optional<Product> opt = productDAO.findById(pid);

		if (opt.isPresent()) {
			Product dbproduct = opt.get();
			dbproduct.setBrand(product.getBrand());
			dbproduct.setCategory(product.getCategory());
			dbproduct.setDescription(product.getDescription());
			dbproduct.setPrice(product.getPrice());
			dbproduct.setQuantity(product.getQuantity());

			productDAO.save(dbproduct);

			return "product updated successfully";
		}

		return "Product Not found";
	}
}
