package com.niit.DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Orders;



@Repository("orderDAO")
@Transactional
public class OrdersDAOImpl implements OrdersDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean receiptGenerate(Orders order) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(order);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateCartItemStatus(String username) 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("update Cart set status='P' where username=:username");
		query.setParameter("username", username);
		int row_eff=query.executeUpdate();
		return row_eff>0;
	}

}
