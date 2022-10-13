package com.java.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.entity.Product;
import com.java.service.ProductService;

@RestController
@CrossOrigin("*")
@RequestMapping("/rest/products")
public class ProductRestController {
	@Autowired
	ProductService productService;
	
	@GetMapping
	public List<Product> getAll() {
		return productService.findAll();
	}
	
	@PostMapping
	public Product add(@RequestBody Product product) {
		return productService.add(product);
	}
	
	@PutMapping("{maSP}")
	public Product update(@PathVariable("maSP") Long maSP, @RequestBody Product product) {
		return productService.update(product);
	}
	
	@DeleteMapping("{maSP}")
	public void delete(@PathVariable("maSP") Long maSP) {
		productService.delete(maSP);
	}
}