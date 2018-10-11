package com.niit.DAO;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Cart;


	@Repository("cartDAO")
	@Transactional
	public class CartDAOImpl implements CartDAO
	{
		@Autowired
		private SessionFactory sessionFactory;
		
		public boolean addToCart(Cart cart) 
		{
			try
			{
				sessionFactory.getCurrentSession().save(cart);	
				return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return false;	
			}
		}

		public boolean deleteFromCart(Cart cart) 
		{
			try
			{
				sessionFactory.getCurrentSession().delete(cart);
				return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return false;
			}
		}

		public boolean updateCart(Cart cart) 
		{
			try
			{
				sessionFactory.getCurrentSession().update(cart);
				return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return false;
			}
		}

		public Cart getCartItem(int cartId) 
		{
			Session session=sessionFactory.openSession();
			Cart cartItem=(Cart)session.get(Cart.class,cartId);
			return cartItem;
		}

		public List<Cart> listCartItems(String username) 
		{
			Session session=sessionFactory.openSession();
			List<Cart> listCartItems=(List<Cart>)session.createQuery("from Cart where username=:username and status='NP'").setParameter("username", username).list();
			return listCartItems;
		}



	}
