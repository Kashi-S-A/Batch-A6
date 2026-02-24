package com.tyss.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

	@GetMapping("/fetch")
	public String fetch() {
		return "Product Fetched";
	}

	@PostMapping("/save")
	public String save() {
		return "Product Saved";
	}

	@PutMapping("/update")
	public String update() {
		return "Product updated";
	}

	@DeleteMapping("/delete")
	public String delete() {
		return "Product deleted";
	}

}
