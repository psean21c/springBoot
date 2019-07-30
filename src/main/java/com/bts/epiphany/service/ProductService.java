package com.bts.epiphany.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bts.epiphany.model.Product;

@Service
public class ProductService {

	List<Product> products = new ArrayList<Product> (Arrays.asList(
			new Product(1,"Prod1",10),
			new Product(2,"Prod2",20),
			new Product(3,"Prod3",30)			
			));

	public List<Product> getAllProducts(){
		return products;
	}
	
}
