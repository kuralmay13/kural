package com.niit.shopkartbackend.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shopkartbackend.model.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO{

	@Autowired
private SessionFactory sessionFactory;
	
	public CategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public void saveOrUpdate(Category category) {
		
		System.out.println(category.getId());
		
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		}
	
	@Transactional
	public Category getByName(String name)
	{
		String hql="from Category where name="+"'"+name+"'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		 @SuppressWarnings("unchecked")
		List<Category> listCategory=query.list();
		if(listCategory!=null && !listCategory.isEmpty()){
			return listCategory.get(0);
		}
		else{
			
			return null;
		}
	}
	
	@Transactional
	public void delete(int id) {
		Category CategoryToDelete = new Category();
		CategoryToDelete.setId(id);;
		sessionFactory.getCurrentSession().delete(CategoryToDelete);
	}
	
		
	@Transactional
	public Category get(int id) {
		String hql = "from Category where id = "+"'"+id+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		 @SuppressWarnings("unchecked")
		List<Category> listCategory = query.list();
		
		if(listCategory!=null && !listCategory.isEmpty()) 
		{
			return listCategory.get(0);
		}
		return null;
		
		}
	
	@Transactional
	public List<Category> list() {
		@SuppressWarnings("unchecked")
		List<Category> listcategory=(List<Category>) sessionFactory.getCurrentSession().createCriteria(Category.class).list();
		return listcategory;
	}

	}

	

