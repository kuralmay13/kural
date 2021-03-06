package com.niit.shopkartbackend.dao;

import java.util.List;

import com.niit.shopkartbackend.model.Supplier;

public interface SupplierDAO {

	public List<Supplier>list();
	public Supplier get(int id);
	public void saveOrUpdate(Supplier supplier);
	public void delete(int id);
}

