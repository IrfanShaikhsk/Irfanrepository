package com.niit.MYfirstbackend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.OrdersDAO;
import com.niit.model.Orders;

public class OrdersDAOTestCase {
	private static AnnotationConfigApplicationContext context;
	private static OrdersDAO orderDAO;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		
		orderDAO = (OrdersDAO) context.getBean("orderDAO");
	}
	@Ignore
	@Test
	public void receipt()
	{
		Orders order = new Orders();
		order.setUsername("Irfan");
		order.setPurchaseValue(1100);
		order.setPaymentMode("Cash");
		order.setOrderDate(new java.util.Date());
		
		boolean result = orderDAO.receiptGenerate(order);
		assertEquals("New Order", true, result);
		
	}
}
