package com.niit.DAO;

import com.niit.Model.User;

public interface UserDAO {

	public void registration(User user);
	boolean isEmailUnique(String email);
	User login(User user);
	void updateUser(User user);
	User getUser(String email);

}
