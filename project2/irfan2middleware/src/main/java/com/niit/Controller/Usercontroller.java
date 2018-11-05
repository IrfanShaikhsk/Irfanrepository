package com.niit.Controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.DAO.UserDAO;
import com.niit.Model.Errorclass;
import com.niit.Model.User;


@Controller
public class Usercontroller {
	@Autowired
private UserDAO userDao;
	public Usercontroller(){
		System.out.println("UserController bean is created");
	}
    @RequestMapping(value="/register",method=RequestMethod.POST)
	public ResponseEntity<?>  registration(@RequestBody User user){
		try{
			
			if(!userDao.isEmailUnique(user.getEmail())){
				Errorclass errorClazz=new Errorclass(2,"Email id already exists.. Please choose different email id");
				return new ResponseEntity<Errorclass>(errorClazz,HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		userDao.registration(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
		}catch(Exception e){
			Errorclass errorClazz=new Errorclass(1,"Something went wrong. "+e.getMessage());
			return new ResponseEntity<Errorclass>(errorClazz,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
    
    
	@RequestMapping(value="/login",method=RequestMethod.PUT)
	public ResponseEntity<?> login(@RequestBody User user,HttpSession session){
	User validUser=userDao.login(user);
	if(validUser==null){
		Errorclass errorClazz=new Errorclass(4,"Invalid email/password...");
		return new ResponseEntity<Errorclass>(errorClazz,HttpStatus.UNAUTHORIZED);
	}
	else{
		validUser.setOnline(true);
		userDao.updateUser(validUser);
		session.setAttribute("loggedInUser", validUser.getEmail());
		System.out.println("Session Id" + session.getId());
		System.out.println("Session Attribute " + session.getAttribute("loggedInUser"));
		System.out.println("Created On " + session.getCreationTime());
		return new ResponseEntity<User>(validUser,HttpStatus.OK);
	}
	}
   /* @RequestMapping(value="/getalljobs",method=RequestMethod.GET)
	public ResponseEntity<?> getAllJobs(HttpSession session){
    	System.out.println("Session Id" + session.getId());
		System.out.println("Session Attribute " + session.getAttribute("loggedInUser"));
		System.out.println("Created On " + session.getCreationTime());
		String email=(String)session.getAttribute("loggedInUser");
		if(email==null){
			Errorclass errorClazz=new Errorclass(4,"Unauthorized access... please login..");
			return new ResponseEntity<Errorclass>(errorClazz,HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}*/
	
	
	
	@RequestMapping(value="/logout",method=RequestMethod.PUT)
    public ResponseEntity<?> logout(HttpSession session){
		String email=(String)session.getAttribute("loggedInUser");
		if(email==null){
			Errorclass errorClazz=new Errorclass(4,"Unauthorized access... please login..");
			return new ResponseEntity<Errorclass>(errorClazz,HttpStatus.UNAUTHORIZED);
		}
		User user=userDao.getUser(email);
		user.setOnline(false);
		userDao.updateUser(user);
		session.removeAttribute("loggedInUser");
		session.invalidate();
    	return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @RequestMapping(value="/updateprofile",method=RequestMethod.PUT)
	public ResponseEntity<?> updateUserProfile(@RequestBody User user,HttpSession session){
    	String email=(String)session.getAttribute("loggedInUser");
    	if(email==null){
			Errorclass errorClazz=new Errorclass(4,"Unauthorized access... please login..");
			return new ResponseEntity<Errorclass>(errorClazz,HttpStatus.UNAUTHORIZED);
		}
    	try{
    	userDao.updateUser(user);
    	}catch(Exception e){
    		Errorclass errorClazz=new Errorclass(5,"Unable to update user details..");
    		return new ResponseEntity<Errorclass>(errorClazz,HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	return new ResponseEntity<User>(user,HttpStatus.OK);
	}
}
