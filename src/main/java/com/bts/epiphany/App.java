package com.bts.epiphany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bts.epiphany.service.ProductService;


@SpringBootApplication
//@ComponentScan("com.bts.epiphany.service, com.bts.epiphany.controller")
public class App {

	@Autowired
	ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
