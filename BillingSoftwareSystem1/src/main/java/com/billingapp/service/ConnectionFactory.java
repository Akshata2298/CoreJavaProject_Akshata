package com.billingapp.service;

import com.billingapp.dao.ProductDaoImpl;
import com.billingapp.model.Product;

public class ConnectionFactory {

	public static void main(String[] args) {
		
		ProductDaoImpl daoImpl=new ProductDaoImpl();
		Product product = null;
		//daoImpl.addProducts(product);
		daoImpl.buyProducts(product);

	}

}
