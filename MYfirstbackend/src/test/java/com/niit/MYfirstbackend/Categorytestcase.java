package com.niit.MYfirstbackend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.CategoryDAO;
import com.niit.model.Category;





public class Categorytestcase 
{

	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	@Test
	public void addCategoryTest()
	{
		Category category=new Category();
		category.setCategoryName("MensWear");
		category.setCategoryDesc("All Size available");
		
		assertTrue("Problem in Adding Category",categoryDAO.addCategory(category));
	}
	
	
	
		
	@Ignore
	@Test
	public void getCategoryDetails()
	{
		Category category = categoryDAO.getCategory(1);
		String name = category.getCategoryName();
		assertEquals("Apparels", name);
	}

}