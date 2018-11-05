package com.niit.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.DAO.NotificationDao;
import com.niit.Model.Errorclass;
import com.niit.Model.Notification;

@Controller
public class NotificationController {
	@Autowired
private NotificationDao notificationDao;public NotificationController() {
	System.out.println("Notification Controller bean created");
}


@RequestMapping(value="/notifications",method=RequestMethod.GET)
public ResponseEntity<?> getNotificationsNotViewed(HttpSession session){
String email=(String)session.getAttribute("loggedInUser");
if(email==null){
	Errorclass errorClazz=new Errorclass(5,"Unauthorized access.. please login..");
	return new ResponseEntity<Errorclass>(errorClazz,HttpStatus.UNAUTHORIZED);
}
List<Notification> notifications=notificationDao.getNotificationNotViewed(email);
return new ResponseEntity<List<Notification>>(notifications,HttpStatus.OK);
}
@RequestMapping(value="/notification/{id}",method=RequestMethod.GET)
public ResponseEntity<?> getNotification(@PathVariable int id,HttpSession session){
	String email=(String)session.getAttribute("loggedInUser");
	if(email==null){
		Errorclass errorClazz=new Errorclass(5,"Unauthorized access.. please login..");
		return new ResponseEntity<Errorclass>(errorClazz,HttpStatus.UNAUTHORIZED);
	}
	Notification notification=notificationDao.getNotification(id);
	return new ResponseEntity<Notification>(notification,HttpStatus.OK);
}

@RequestMapping(value="/updatenotification/{id}",method=RequestMethod.PUT)
public ResponseEntity<?> updatenotification(@PathVariable int id,HttpSession session){
	String email=(String)session.getAttribute("loggedInUser");
	if(email==null){
		Errorclass errorClazz=new Errorclass(5,"Unauthorized access.. please login..");
		return new ResponseEntity<Errorclass>(errorClazz,HttpStatus.UNAUTHORIZED);
	}
	notificationDao.updateNotification(id);
	return new ResponseEntity<Void>(HttpStatus.OK);
} 

}