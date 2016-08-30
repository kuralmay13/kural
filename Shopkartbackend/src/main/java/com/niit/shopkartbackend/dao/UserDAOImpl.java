package com.niit.shopkartbackend.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shopkartbackend.model.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
		
		public UserDAOImpl(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}
		
		@Transactional
		public void saveOrUpdate(User user) {
			user.setEnabled(true);
			user.setRole("ROLE_USER");
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			}
		
		@Transactional
		public void delete(int id) {
			User userToDelete = new User();
			userToDelete.setId(id);
			sessionFactory.getCurrentSession().delete(userToDelete);
		}
		
		
		@Transactional
		public User get(String id) {
			String hql = "from User where username = "+"'"+id+"'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			 @SuppressWarnings("unchecked")
			List<User> listUser = query.list();
			
			if(listUser !=null && !listUser.isEmpty()) 
			{
				return listUser.get(0);
			}
			return null;
		}

		
		@Transactional
		public boolean isValidUser(String username,String password){
			String hql = "from User where username = '"+ username + "'and "+"password = '"+ password+ "'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			 @SuppressWarnings("unchecked")
			 List<User> listUser = query.list();
			 
			 if(listUser !=null && !listUser.isEmpty()) 
				{
				 
				 return true;
				 
				}
			 
			 return false;
		}
		
		
		@Transactional
		public List<User> list() {
			@SuppressWarnings("unchecked")
			List<User> listuser=(List<User>) sessionFactory.getCurrentSession().createCriteria(User.class).list();
			return listuser;
		}

			
		}

