package com.billingapp.dao;

import com.billingapp.model.Product;




public interface ProductDao {

	public void addProducts(Product product);
	
	public float buyProducts(Product product);

}
