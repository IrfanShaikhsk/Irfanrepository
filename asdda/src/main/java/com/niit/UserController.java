package com.niit;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.DAO.UserDAO;
import com.niit.model.User;
@Controller

public class UserController {
	@Autowired
	private UserDAO  userDAO;
	

	
	@Autowired
	private User user;
	
	
	
	
	@RequestMapping(value="login_success")
	public String loginSuccess(HttpSession session, Model m)
	{
		System.out.println("Entered in Function");
		String page="";
		
		boolean loggedIn = false;
		
		SecurityContext securitycontext = SecurityContextHolder.getContext();
		Authentication authentic = securitycontext.getAuthentication();
		
		String username = authentic.getName();
		
		Collection<GrantedAuthority> roles = (Collection<GrantedAuthority>)authentic.getAuthorities();
		
		for(GrantedAuthority role:roles)
		{
			session.setAttribute("role", role.getAuthority());
			
			if(role.getAuthority().equals("ROLE_ADMIN"))
			{
				loggedIn = true;
				page="AdminHomePage";
				session.setAttribute("loggedIn", loggedIn);
				session.setAttribute("username", username);
			}
			else
			{
				if(role.getAuthority().equals("ROLE_USER"))
				{
					loggedIn = true;
					page="Home";
					session.setAttribute("loggedIn", loggedIn);
					session.setAttribute("username", username);
				}
			}
		}
		
		return page;
	}
	
	@PostMapping("RegisterUser")
	public String registerUser(@RequestParam String username,
							   @RequestParam String password,
							   @RequestParam String customerName,
							   @RequestParam String mobileNo,
							   @RequestParam String emailId,
							   @RequestParam String address,
							   Model m)
	{
		user.setUsername(username);
		user.setPassword(password);
		user.setCustomerName(customerName);
		user.setMobileNo(mobileNo);
		user.setEmailId(emailId);
		user.setAddress(address);
		user.setRole("ROLE_USER");
		
		if(userDAO.save(user))
		{
			m.addAttribute("msg", "You Registered Successfully. Please Login to continue.");
			return "Login";
		}
		else
		{
			m.addAttribute("msg", "Registration Failed!!!");
			return "Register";
		}	
	}
	

}
