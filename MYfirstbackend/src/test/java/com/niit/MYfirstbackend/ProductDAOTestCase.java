package com.niit.MYfirstbackend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.ProductDAO;
import com.niit.model.Product;


public class ProductDAOTestCase {

	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		
		productDAO = (ProductDAO) context.getBean("productDAO");
	}

		@Test
		public void addProductTest()
		{
			Product product=new Product();
			product.setProductName("Newproduct");
			product.setProdDesc("L");
			product.setPrice(2000);
			product.setStock(10);
			product.setCategoryId(1);
			
			assertTrue("Problem in Adding Product",productDAO.addProduct(product));
		}
		

		@Ignore
		@Test
		public void deleteProductTest()
		{
			Product product=productDAO.getProduct(2);
			assertTrue("Problem in Deleting:",productDAO.deleteProduct(product));
		}
		@Ignore
		@Test
		public void listProductsTest()
		{
			List<Product> listProducts=productDAO.listProducts();
			assertNotNull("Problem in Retrieving:",listProducts);
		}
		
	
}
