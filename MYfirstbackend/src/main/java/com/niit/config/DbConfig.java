package com.niit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.model.Cart;
import com.niit.model.Category;
import com.niit.model.Orders;
import com.niit.model.Product;
import com.niit.model.Supplier;
import com.niit.model.User;



@Configuration
@EnableTransactionManagement
public class DbConfig {
	
	@Autowired
	@Bean(name="dataSource")
	public DataSource getH2DataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test"); //if error db already in use or file is locked
		dataSource.setUsername("dteja");
		dataSource.setPassword("dteja");

		System.out.println("DB Connected");
		return dataSource;
	
}
	
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource)
	{
		
		Properties properties=new Properties();
		
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		
		LocalSessionFactoryBuilder sessionFactoryBuilder=new LocalSessionFactoryBuilder(dataSource);
     
		sessionFactoryBuilder.addAnnotatedClass(Product.class);
		sessionFactoryBuilder.addAnnotatedClass(Category.class);
		sessionFactoryBuilder.addAnnotatedClass(Supplier.class);
		sessionFactoryBuilder.addAnnotatedClass(User.class);
		sessionFactoryBuilder.addAnnotatedClass(Cart.class);
		sessionFactoryBuilder.addAnnotatedClass(Orders.class);
		sessionFactoryBuilder.addProperties(properties);
		
		SessionFactory sessionFactory=sessionFactoryBuilder.buildSessionFactory();
		System.out.println("Creating SessionFactory Bean");
		return sessionFactory;
	}
	
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("Hibernate Transaction Object Created");
		return new HibernateTransactionManager(sessionFactory);
	}

}
