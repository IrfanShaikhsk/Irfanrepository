package com.niit.DAO;

import java.util.List;

import com.niit.model.Cart;

public interface CartDAO 
{
	public boolean addToCart(Cart cart);
	public boolean deleteFromCart(Cart cart);
	public boolean updateCart(Cart cart);
	public Cart getCartItem(int cartId);
	public List<Cart> listCartItems(String username);
	
}