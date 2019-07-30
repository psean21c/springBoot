package com.bts.epiphany.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product{

	@Id
	int productId;
	String name;
	int age;
	
	public Product(){
	}
	
	public Product(int productId, String name, int age) {
		this.productId = productId;
		this.name = name;
		this.age = age;
	}
	
	public long getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Customer [age=" + age + ", productId=" + productId + ", name=" + name
				+ "]";
	}
}