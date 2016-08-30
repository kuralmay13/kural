package com.niit.shopkartbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shopkartbackend.dao.CategoryDAO;
import com.niit.shopkartbackend.model.Category;



public class CategoryTest {

	public static void main (String[] args)

	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit");
		context.refresh();
		
		CategoryDAO categoryDAO =(CategoryDAO) context.getBean("categoryDAO");
		Category category =new Category();
	
		
		categoryDAO.saveOrUpdate(category);
}
}
