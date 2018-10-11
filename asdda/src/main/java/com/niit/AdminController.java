
package com.niit;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.DAO.CategoryDAO;
import com.niit.DAO.ProductDAO;
import com.niit.model.Category;
import com.niit.model.Product;



@Controller
public class AdminController 
{
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(value= "/manage_categories")
	public String manageCategories(Model m)
	{
		
		m.addAttribute("isAdminClickedManageCategories", true);
		List<Category> listCategories = categoryDAO.listCategories();
		m.addAttribute("listCategories", listCategories);
		return "AdminHomePage";
	}
	
	@RequestMapping(value= "/manage_products")
	public String manageProducts(Model m)
	{
		Product product=new Product();
		m.addAttribute("product",product);
		
		m.addAttribute("isAdminClickedManageProducts", true);
		
		List<Product> listProducts = productDAO.listProducts();
		m.addAttribute("listProducts", listProducts);
		
		m.addAttribute("categoryList", this.getAllCategories());
		return "AdminHomePage";
	}
	
	public LinkedHashMap<Integer,String> getAllCategories()
	{
		List<Category> listCategories=categoryDAO.listCategories();
		
		LinkedHashMap<Integer,String> categoryList=new LinkedHashMap<Integer,String>();
		
		for(Category category:listCategories)
		{
			categoryList.put(category.getCategoryId(), category.getCategoryName());
		}
		
		return categoryList;
	}
}
