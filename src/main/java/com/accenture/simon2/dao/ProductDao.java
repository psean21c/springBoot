package com.accenture.simon2.dao;

import java.util.List;
import com.accenture.simon2.model.Product;


public interface ProductDao {
	void insert(Product product);
	void inserBatch(List<Product> products);
	List<Product> loadAllProduct();
	Product findProductById(long productId);
	String findNameById(long productId);
	int getTotalNumberProduct();
}
