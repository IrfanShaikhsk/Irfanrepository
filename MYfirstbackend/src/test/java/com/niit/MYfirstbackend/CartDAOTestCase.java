
package com.niit.MYfirstbackend;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.CartDAO;
import com.niit.model.Cart;




public class CartDAOTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static CartDAO cartDAO;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		
		cartDAO = (CartDAO) context.getBean("cartDAO");
	}
	
	
	@Test
	public void addtoCartTest()
	{
		Cart cart=new Cart();
		cart.setProductId(1);
		cart.setProductName("MyProduct");
		cart.setQuantity(1);
		cart.setPrice(2800);
		cart.setUsername("Irfan");
		cart.setStatus("NA");
		
		assertTrue("Problem in adding Cart",cartDAO.addToCart(cart));
	}

	

	@Ignore
	@Test
	public void updateCartTest()
	{
		Cart cart=cartDAO.getCartItem(2); // put the correct Cartid from DB
		cart.setQuantity(2);
		assertTrue("Problem in Updating",cartDAO.updateCart(cart));
	}
	
	@Ignore
	@Test
	public void deletefromCartTest()
	{
		Cart cart=cartDAO.getCartItem(2);
		assertTrue("Problem in Deleting:",cartDAO.deleteFromCart(cart));
	}
	
	
	/*@Test
	public void listCartItemsTest()
	{
		List<Cart> listCartItems=cartDAO.listCartItems
		assertNotNull("Problem in Retrieving:",listCartItems);
	}
*/
}

