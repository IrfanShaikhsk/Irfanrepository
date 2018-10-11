package com.niit;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController 
{
	@RequestMapping(value= "/")
	public String homePage()
	{
		return "Home";
	}

	@RequestMapping(value="/login")
	public String loginPage()
	{
		System.out.println("Entered function");
		return "Login";
	}

	@RequestMapping(value="/register")
	public String registerPage()
	{
		return "Register";
	}
	
	@RequestMapping(value="/contactus")
	public String Contactus()
	{
		return "ContactUs";
	}
	@RequestMapping(value= "/home")
	public String home()
	{
		return "Home";
	}
	
}