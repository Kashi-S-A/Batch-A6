package com.tyss.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
import com.tyss.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductService productService;

	@GetMapping("/all")
	public List<Product> fetch() {
		List<Product> products = productRepository.findAll();
		return products;
	}

	@GetMapping("/byId")
	public ResponseEntity<Product> fetchById(@RequestParam Integer pid) {

//		Optional<Product> opt = productRepository.findById(pid);
//
//		if (opt.isPresent()) {
//			Product product = opt.get();
//			return product;
//		} else {
////			return null;
//			throw new RuntimeException("Product not found");
//		}
		
		Product product = productRepository.findById(pid).orElseThrow(() -> new RuntimeException("Product not found"));

		ResponseEntity<Product> resp = new ResponseEntity<Product>(product, HttpStatus.OK);
		
		ResponseEntity<Product> responseEntity = ResponseEntity.status(HttpStatus.OK).body(product);
		
		return  resp;
	}

	@PostMapping("/save")
	public ResponseEntity<Product> save(@RequestBody Product product) {
		
		Product savedProduct = productRepository.save(product);
		
		ResponseEntity<Product> resp = new ResponseEntity<Product>(savedProduct, HttpStatus.CREATED);
		
		ResponseEntity<Product> responseEntity = ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);

		return resp;
	}

	@PutMapping("/update/pid/{pid}")
	public String update(@PathVariable Integer pid, @RequestBody Product product) {
		return productService.updateProduct(pid, product);
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

	@GetMapping("/cat")
	public List<Product> byCategory(@RequestParam(name = "cat") String category) {

//		List<Product> products = productRepository.getProductByCategory(category);

		List<Product> products = productRepository.findByCategory(category);

		return products;
	}

	@GetMapping("/range")
	public List<Product> byPriceRange(@RequestParam Double from, @RequestParam Double to) {
//		return productRepository.getProductByRange(from, to);
		return productRepository.findByPriceBetween(from, to);
	}

	@GetMapping("/pagination")
	public List<Product> byPage(@RequestParam Integer pageNumber) {

		Pageable pageable = PageRequest.of(pageNumber - 1, 10);

		Page<Product> all = productRepository.findAll(pageable);

		List<Product> products = all.toList();

		return products;
	}

	@GetMapping("/sort")
	public List<Product> sorting(@RequestParam String sort) {

		List<Product> products = productRepository.findAll(Sort.by(sort).ascending());// by default sorts in ascending

		return products;
	}

	@GetMapping("/filter")
	public List<Product> filterProducts(@RequestBody Product product) {

		Example<Product> of = Example.of(product);

		List<Product> products = productRepository.findAll(of);

		return products;
	}

	@GetMapping(value = "/content", consumes = {
													"application/json",
													"application/xml"
									}, 
									produces =  {
											"application/json",
											"application/xml"
							}
	)
	public Product contentType(@RequestBody Product product) {

		System.out.println(product.getPid());
		System.out.println(product.getBrand());
		System.out.println(product.getCategory());
		System.out.println(product.getDescription());
		System.out.println(product.getPrice());
		System.out.println(product.getQuantity());

		return product;
	}
	
	@GetMapping("/exc")
	public String m1() {
		
		System.out.println("got the request");
		
//		String s = null;
//		
//		System.out.println(s.charAt(10));
		
		int a = 10/0;
		
		return "Thank you for calling";
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e) {
		System.out.println("exception handled in LOCAL");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<String> handleNullPointerException(NullPointerException exception)
	{
		System.out.println("Handled NPE in LOCAL");
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}	
	
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<String> handleArithmeticException(ArithmeticException exception) {
		
		System.out.println("Handled AE in LOCAL");
		
		String msg = exception.getMessage();
		
		ResponseEntity<String> resp = new ResponseEntity<String>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
		
		return resp;
	}
	

}
