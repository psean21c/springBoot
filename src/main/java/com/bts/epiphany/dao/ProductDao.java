package com.bts.epiphany.dao;

import java.util.List;

import com.bts.epiphany.model.Product;



public interface ProductDao {
	void insert(Product product);
	void inserBatch(List<Product> products);
	List<Product> loadAllProduct();
	Product findProductById(long productId);
	String findNameById(long productId);
	int getTotalNumberProduct();
}
