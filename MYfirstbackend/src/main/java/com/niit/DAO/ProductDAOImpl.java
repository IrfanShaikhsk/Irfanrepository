package com.niit.DAO;

import java.sql.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Product;


@Repository("productDAO")
@Transactional
public  class ProductDAOImpl implements ProductDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean addProduct(Product product) 
	{
		try 
		{
			product.setAdded_date(new Date(System.currentTimeMillis()));
			sessionFactory.getCurrentSession().saveOrUpdate(product);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteProduct(Product product) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(product);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public Product getProduct(int productId) 
	{
		Session session=sessionFactory.openSession();
		Product product=(Product)session.get(Product.class,productId);
		session.close();
		return product;
	}

	public List<Product> listProducts() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product");
		List<Product> listProducts=query.list();
		session.close();
		return listProducts;
	}

	


}
