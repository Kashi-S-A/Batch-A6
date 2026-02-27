package com.tyss.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.entity.Product;
import com.tyss.repo.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/all")
	public List<Product> fetch() {
		List<Product> products = productRepository.findAll();
		return products;
	}

	@GetMapping("/byId")
	public Product fetchById(@RequestParam Integer pid) {

//		Optional<Product> opt = productRepository.findById(pid);
//
//		if (opt.isPresent()) {
//			Product product = opt.get();
//			return product;
//		} else {
////			return null;
//			throw new RuntimeException("Product not found");
//		}

		return productRepository.findById(pid).orElseThrow(() -> new RuntimeException("Product not found"));
	}

	@PostMapping("/save")
	public Product save(@RequestBody Product product) {
		Product savedProduct = productRepository.save(product);

		return savedProduct;
	}

	@PutMapping("/update/pid/{pid}")
	public String update(@PathVariable Integer pid, @RequestBody Product product) {

		Optional<Product> opt = productRepository.findById(pid);

		if (opt.isPresent()) {
			Product dbproduct = opt.get();
			dbproduct.setBrand(product.getBrand());
			dbproduct.setCategory(product.getCategory());
			dbproduct.setDescription(product.getDescription());
			dbproduct.setPrice(product.getPrice());
			dbproduct.setQuantity(product.getQuantity());

			productRepository.save(dbproduct);

			return "product updated successfully";
		}

		return "Product Not found";
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable(name = "id") int pid) {

		Optional<Product> opt = productRepository.findById(pid);

		if (opt.isPresent()) {
			productRepository.deleteById(pid);
			return "product deleted";
		}
		return "Product not found";
	}

}
