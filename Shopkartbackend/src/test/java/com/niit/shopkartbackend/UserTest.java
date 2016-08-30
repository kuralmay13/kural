/*package com.niit.shopkartbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shopkartbackend.dao.UserDAO;
import com.niit.shopkartbackend.model.User;



public class UserTest {

	public static void main (String[] args)

	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.shopkartbackend");
		context.refresh();
		UserDAO userDAO =(UserDAO) context.getBean("userDAO");
		User user =new User();
		
	
		userDAO.saveOrUpdate(user);
	}
	
}
*/