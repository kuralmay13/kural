package com.niit.shopkartbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shopkartbackend.dao.SupplierDAO;
import com.niit.shopkartbackend.model.Supplier;

public class SupplierTest {

	public static void main (String[] args)

	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.shopkartbackend");
		context.refresh();
		SupplierDAO supplierDAO =(SupplierDAO) context.getBean("supplierDAO");
		Supplier supplier =new Supplier();
		
		supplierDAO.saveOrUpdate(supplier);
	}
	
}
