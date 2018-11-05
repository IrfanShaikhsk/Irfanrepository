package com.niit.Controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.DAO.JobDao;
import com.niit.DAO.UserDAO;
import com.niit.Model.Errorclass;
import com.niit.Model.Job;
import com.niit.Model.User;

public class Jobcontroller {
	@Autowired
private JobDao jobDao;
	@Autowired
private UserDAO userDao;
	@RequestMapping(value="/addjob",method=RequestMethod.POST)
	public ResponseEntity<?> saveJob(@RequestBody Job job,HttpSession session){
		String email=(String)session.getAttribute("loggedInUser");
		//CHECK FOR AUTHENTICATION
    	if(email==null){
			Errorclass errorClazz=new Errorclass(4,"Unauthorized access... please login..");
			return new ResponseEntity<Errorclass>(errorClazz,HttpStatus.UNAUTHORIZED);
		}
    	//CHECK FOR AUTHORIZATION[ROLE]
    	User user=userDao.getUser(email);
    	if(!user.getRole().equals("ADMIN")){
    		Errorclass errorClazz=new Errorclass(5,"Access Denied...You are not authorized to post a job");
    		return new ResponseEntity<Errorclass>(errorClazz,HttpStatus.UNAUTHORIZED);
    	}
    	try{
        job.setPostedon(new Date());		
    	jobDao.saveJob(job);
    	}catch(Exception e){
    		Errorclass errorClazz=new Errorclass(6,"Unable to post job details");
    		return new ResponseEntity<Errorclass>(errorClazz,HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	return new ResponseEntity<Job>(job,HttpStatus.OK);
	}
	@RequestMapping(value="/getalljobs",method=RequestMethod.GET)
	public ResponseEntity<?> getAllJobs(HttpSession session){
		String email=(String)session.getAttribute("loggedInUser");
		if(email==null){
			Errorclass errorClazz=new Errorclass(4,"Unauthorized access... please login..");
			return new ResponseEntity<Errorclass>(errorClazz,HttpStatus.UNAUTHORIZED);
		}
		List<Job> jobs=jobDao.getAllJobs();
		return new ResponseEntity<List<Job>>(jobs,HttpStatus.OK);
	}

}
