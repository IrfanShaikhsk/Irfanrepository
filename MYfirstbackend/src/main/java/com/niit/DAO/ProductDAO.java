package com.niit.DAO;

import java.util.List;

import com.niit.model.Product;

public interface ProductDAO 
{

	public boolean addProduct(Product product);
	public Product getProduct(int ProductId);
	public boolean deleteProduct(Product product);
	//public boolean updateProduct(Product product);
	public List<Product> listProducts();
	
}