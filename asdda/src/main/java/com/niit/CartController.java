package com.niit;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.DAO.CartDAO;
import com.niit.DAO.ProductDAO;
import com.niit.model.Cart;
import com.niit.model.Product;

public class CartController {
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(value="/myCart")
	public String myCart(Model m, HttpSession httpsession)
	{
		String username = (String) httpsession.getAttribute("username");
		List<Cart> listCartItems = cartDAO.listCartItems(username);
		m.addAttribute("listCartItems", listCartItems);
		m.addAttribute("totalCost", this.calculateTotalCost(listCartItems));
		httpsession.setAttribute("CartItems",listCartItems.size());
		
		return "Cart";
	}
	
	@RequestMapping(value="/addToCart/{productId}")
	public String addToCart(@PathVariable("productId") int productId,
			@RequestParam("quantity")int quantity,HttpSession httpsession,Model m)
	{
		Cart cart = new Cart();
		Product product = productDAO.getProduct(productId);
		String username = (String) httpsession.getAttribute("username");
		
		cart.setProductId(productId);
		cart.setProductName(product.getProductName());
		cart.setQuantity(quantity);
		cart.setPrice(product.getPrice());
		cart.setStatus("NP");
		cart.setUsername(username);
		
		cartDAO.addToCart(cart);
		
		List<Cart> listCartItems = cartDAO.listCartItems(username);
		m.addAttribute("listCartItems", listCartItems);
		m.addAttribute("totalCost", this.calculateTotalCost(listCartItems));
		httpsession.setAttribute("CartItems",listCartItems.size());
		
		return "Cart";
	}
	
	@RequestMapping(value="/deleteCartItem/{cartId}")
	public String deleteCartItem(@PathVariable("cartId")int cartId,HttpSession httpsession,Model m)
	{
		Cart cart = cartDAO.getCartItem(cartId);
		cartDAO.deleteFromCart(cart);
		
		String username = (String) httpsession.getAttribute("username");
		List<Cart> listCartItems = cartDAO.listCartItems(username);
		m.addAttribute("listCartItems", listCartItems);
		m.addAttribute("totalCost", this.calculateTotalCost(listCartItems));
		httpsession.setAttribute("CartItems",listCartItems.size());
		
		return "Cart";
	}
	
	@RequestMapping(value="/updateCartItem/{cartId}")
	public String updateCartItem(@PathVariable("cartId")int cartId,@RequestParam("quantity") int quantity,HttpSession httpsession,Model m)
	{
		Cart cart = cartDAO.getCartItem(cartId);
		cart.setQuantity(quantity);
		cartDAO.updateCart(cart);

		String username = (String) httpsession.getAttribute("username");
		List<Cart> listCartItems = cartDAO.listCartItems(username);
		m.addAttribute("listCartItems", listCartItems);
		m.addAttribute("totalCost", this.calculateTotalCost(listCartItems));
		httpsession.setAttribute("CartItems",listCartItems.size());
		
		return "Cart";
	}
	
	public int calculateTotalCost(List<Cart> cart)
	{
		int totalcost=0;
		int count=0;
		
		while(count<cart.size())
		{
			totalcost = totalcost+(cart.get(count).getPrice()*cart.get(count).getQuantity());
			count++;
		}
		
		return totalcost;
	}

}
