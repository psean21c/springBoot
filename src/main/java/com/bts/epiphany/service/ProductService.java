package com.bts.epiphany.service;

import java.util.List;

import com.bts.epiphany.model.Product;


public interface ProductService {
	void insert(Product product);
	void insertBatch(List<Product> products);
	void loadAllProduct();
	void getProductById(long ProductId);
	void getProductNameById(long ProductId);
	void getTotalNumerProduct();
}
