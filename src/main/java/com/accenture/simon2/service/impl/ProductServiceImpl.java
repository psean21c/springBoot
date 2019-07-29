package com.accenture.simon2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.simon2.dao.ProductDao;
import com.accenture.simon2.model.Product;
import com.accenture.simon2.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService{

	@Autowired 
	ProductDao productDao;
	
	@Override
	public void insert(Product cus) {
		productDao.insert(cus);
	}
	
	@Override
	public void insertBatch(List<Product> customers) {
		productDao.inserBatch(customers);
	}	
	
	public void loadAllProduct(){
		List<Product> listCust = productDao.loadAllProduct();
		for(Product cus: listCust){
			System.out.println(cus.toString());
		}
	}


	@Override
	public void getProductById(long productId) {
		Product cust = productDao.findProductById(productId);
		System.out.println(cust);
	}

	@Override
	public void getProductNameById(long productId) {
		String name = productDao.findNameById(productId);
		System.out.println("Product's name = " + name);
	}

	@Override
	public void getTotalNumerProduct() {
		int totalNumberProduct = productDao.getTotalNumberProduct();
		System.out.println("Total Number Product is: " + totalNumberProduct);
	}

}
