package com.bts.epiphany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bts.epiphany.model.Product;
import com.bts.epiphany.service.ProductService;

@RestController
public class ProductServiceController {

	@Autowired
	ProductService productService;

	@RequestMapping("/")
	public String showMain(){
		return "SpringBoot-Accenture";
	}

	@RequestMapping("/products")
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}

}