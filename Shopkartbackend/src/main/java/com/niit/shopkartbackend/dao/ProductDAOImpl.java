package com.niit.shopkartbackend.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shopkartbackend.model.Product;

@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {

@Autowired
private SessionFactory sessionFactory;
	
	public ProductDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public void saveOrUpdate(Product product) {
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		}
	
	@Transactional
	public void delete(int id) {
		Product ProductToDelete = new Product();
		ProductToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(ProductToDelete);
	}
	
	
	@Transactional
	public Product get(int id) {
		String hql = "from Product where id = "+"'"+id+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		 @SuppressWarnings("unchecked")
		List<Product> listProduct = query.list();
		
		if(listProduct !=null && !listProduct.isEmpty()) 
		{
			return listProduct.get(0);
		}
		return null;
	}

	@Transactional
	public List<Product> list() {
		@SuppressWarnings("unchecked")
		List<Product> listproduct=(List<Product>) sessionFactory.getCurrentSession().createCriteria(Product.class).list();
		return listproduct;
	}

}
