package com.niit.DAO;
import java.sql.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.User;


@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	

	public boolean save(User user) 
	{
		try 
		{
			user.setEnabled(true);
			user.setAdded_date(new Date(System.currentTimeMillis()));
			sessionFactory.getCurrentSession().save(user);
		}
		catch(Exception e)
		{
			//e.printStackTrace();
			return false;
		}
		
		return true;
	}

	public boolean delete(String username) 
	{
		User user;
		try 
		{	
			user = getUser(username);
			if(user==null)
			{
				return false;
			}
			sessionFactory.getCurrentSession().delete(user);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	public User getUser(String username) 
	{
		return (User) sessionFactory.getCurrentSession().get(User.class, username);
	}

	public List<User> list(String role) 
	{
		return sessionFactory.getCurrentSession().createCriteria(User.class)
				.add(Restrictions.eq("role", role)).list();
	}

	public User validate(String username, String password) 
	{
		return (User) sessionFactory.getCurrentSession().createCriteria(User.class)
				.add(Restrictions.eq("username", username))
				.add(Restrictions.eq("password", password)).uniqueResult();
	}

}
