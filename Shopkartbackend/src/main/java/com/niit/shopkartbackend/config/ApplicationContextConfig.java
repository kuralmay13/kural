package com.niit.shopkartbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.shopkartbackend.dao.CategoryDAO;
import com.niit.shopkartbackend.dao.CategoryDAOImpl;
import com.niit.shopkartbackend.dao.ProductDAO;
import com.niit.shopkartbackend.dao.ProductDAOImpl;
import com.niit.shopkartbackend.dao.SupplierDAO;
import com.niit.shopkartbackend.dao.SupplierDAOImpl;
import com.niit.shopkartbackend.dao.UserDAO;
import com.niit.shopkartbackend.dao.UserDAOImpl;
import com.niit.shopkartbackend.model.Category;
import com.niit.shopkartbackend.model.Product;
import com.niit.shopkartbackend.model.Supplier;
import com.niit.shopkartbackend.model.User;

@Configuration
@ComponentScan("com.niit.shopkartbackend")
@EnableTransactionManagement


public class ApplicationContextConfig {

  
@Bean(name = "dataSource")
public DataSource getDataSource() {
DriverManagerDataSource dataSource = new DriverManagerDataSource();
dataSource.setDriverClassName("org.h2.Driver");
dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
dataSource.setUsername("sa");
dataSource.setPassword("");
return dataSource;
}
    
   
    
    private Properties getHibernateProperties() {
    Properties properties = new Properties();
    properties.put("hibernate.show_sql", "true");
      properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
     properties.put("hibernate.hbm2ddl.auto", "update");
    return properties;
    }
    
    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
    LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
    sessionBuilder.addProperties(getHibernateProperties());
    sessionBuilder.addAnnotatedClass(Category.class);
    sessionBuilder.addAnnotatedClass(Product.class);
    sessionBuilder.addAnnotatedClass(Supplier.class);
    sessionBuilder.addAnnotatedClass(User.class);
      return sessionBuilder.buildSessionFactory();
    }
    
@Autowired
@Bean(name = "transactionManager")
public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

return transactionManager;
}
    
   


 @Autowired
   @Bean(name = "categoryDAO")
   public CategoryDAO getCategoryDAO(SessionFactory sessionFactory) {
   
return new CategoryDAOImpl(sessionFactory);
   }

 @Autowired
   @Bean(name = "productDAO")
   public ProductDAO getProductDAO(SessionFactory sessionFactory) {
   
return new ProductDAOImpl(sessionFactory);
   }
 
 @Autowired
 @Bean(name = "supplierDAO")
 public SupplierDAO getSupplierDAO(SessionFactory sessionFactory) {
 
return new SupplierDAOImpl(sessionFactory);
 }
 
 @Autowired
 @Bean(name = "userDAO")
 public UserDAO getUserDAO(SessionFactory sessionFactory) {
 
return new UserDAOImpl(sessionFactory);
 }
}