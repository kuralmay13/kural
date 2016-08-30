package com.niit.shopkartbackend.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shopkartbackend.model.Supplier;


@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO {

	@Autowired
	private SessionFactory sessionFactory;
		
		public SupplierDAOImpl(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}
		
		@Transactional
		public void saveOrUpdate(Supplier supplier) {
			sessionFactory.getCurrentSession().saveOrUpdate(supplier);
			}
		
		@Transactional
		public void delete(int id) {
			Supplier SupplierToDelete = new Supplier();
			SupplierToDelete.setId(id);
			sessionFactory.getCurrentSession().delete(SupplierToDelete);
		}
		
		@Transactional
		public Supplier get(int id) {
			String hql = "from Supplier where id = "+"'"+id+"'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			 @SuppressWarnings("unchecked")
			List<Supplier> listSupplier = query.list();
			
			if(listSupplier !=null && !listSupplier.isEmpty()) 
			{
				return listSupplier.get(0);
			}
			return null;
		}

		@Transactional
		public List<Supplier> list() {
			@SuppressWarnings("unchecked")
			List<Supplier> listsupplier=(List<Supplier>) sessionFactory.getCurrentSession().createCriteria(Supplier.class).list();
			return listsupplier;
		}

}
