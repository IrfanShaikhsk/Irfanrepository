package com.niit.DAO;

import java.util.List;

import com.niit.model.User;

public interface UserDAO 
{
	public boolean save(User user);
	public boolean delete(String username);
	public User getUser(String username);
	public List<User> list(String role);
	public User validate(String username, String password);
}