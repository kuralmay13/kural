package com.niit.shopkartbackend.dao;

import java.util.List;

import com.niit.shopkartbackend.model.User;

public interface UserDAO {

	public List<User>list();
	public User get(String id);
	public void saveOrUpdate(User user);
	public void delete(int id);
	public boolean isValidUser(String username,String password);
}
