package com.tyss.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.entity.Product;

@RestController
@RequestMapping("/product")
public class ProductController {

	@GetMapping("/fetch")
	public String fetch(@RequestParam(name = "pid") int id, @RequestParam String name) {
		System.out.println(id);
		System.out.println(name);
		return "Product Id : " + id + ", Name : " + name;
	}

	@PostMapping("/save")
	public Product save(@RequestBody Product product) {
		System.out.println(product);
		return product;
	}

	@PutMapping("/update")
	public String update(@RequestHeader String brand, @RequestHeader String token) {
		System.out.println(brand);
		System.out.println(token);
		return "Product updated";
	}

	@DeleteMapping("/delete/{id}/name/{pname}")
	public String delete(@PathVariable(name = "id") int pid, @PathVariable String pname) {
		System.out.println(pid);
		System.out.println(pname);
		return "Product ID : " + pid + ",Name : " + pname;
	}

}
