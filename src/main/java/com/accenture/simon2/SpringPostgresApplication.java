package com.accenture.simon2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.accenture.simon2.service.ProductService;
import com.accenture.simon2.model.Product;

@SpringBootApplication
@ComponentScan("com.accenture.simon2.service.impl, com.accenture.simon2.dao")
public class SpringPostgresApplication {

	@Autowired
	ProductService productService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringPostgresApplication.class, args);
		ProductService productService = context.getBean(ProductService.class);
		
		/*
		 * Create Product
		 */
		Random r = new Random();

		// Product 1
		Product product1 = new Product();
		Integer product1Id = r.nextInt();
		product1.setProductId(product1Id);
		product1.setName("ProuctSample1");
		product1.setAge(20);

		// Product 2
		Product product2 = new Product();
		Integer product2Id = r.nextInt();
		product2.setProductId(product2Id);
		product2.setName("ProuctSample2");
		product2.setAge(15);

		// Product 3
		Product product3 = new Product();
		Integer product3Id = r.nextInt();
		product3.setProductId(product3Id);
		product3.setName("ProuctSample3");
		product3.setAge(50);

		// Insert a Product to DB
		productService.insert(product1);

		// Insert a List of Product to DB
		List<Product> products = new ArrayList<Product>();
		products.add(product2);
		products.add(product3);
		productService.insertBatch(products);

		// Load All Product and display
		productService.loadAllProduct();

		// Get Product By Id
		System.out.println("=============Get Product By Id");
		productService.getProductById(Long.valueOf(product1Id));

		// Get Product's name by Id
		System.out.println("=============Get Product Name by Id");
		productService.getProductNameById(product2Id);

		// Get Total Products in DB
		System.out.println("=============Get Total Number Product");
		productService.getTotalNumerProduct();

		System.out.println("#######################################");
		System.out.println("Done!!!");
		System.out.println("#######################################");
	}
}

// https://grokonez.com/spring-framework/spring-boot/how-to-use-jdbc-template-with-spring-boot-for-postgres-database
	