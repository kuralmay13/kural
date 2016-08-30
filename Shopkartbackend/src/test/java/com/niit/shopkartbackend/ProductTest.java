package com.niit.shopkartbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shopkartbackend.dao.ProductDAO;
import com.niit.shopkartbackend.model.Product;


public class ProductTest {

	public static void main (String[] args)

	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.shopkartbackend");
		context.refresh();
		ProductDAO productDAO =(ProductDAO) context.getBean("productDAO");
		Product product =new Product();
		
	
		productDAO.saveOrUpdate(product);
	}
	
}
