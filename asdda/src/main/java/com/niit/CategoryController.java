package com.niit;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.DAO.CategoryDAO;
import com.niit.model.Category;






@Controller
public class CategoryController 
{
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	private HttpSession httpsession;

	boolean flag=false;
	
	@RequestMapping(value = "/category/save", method = RequestMethod.POST)
	public String saveCategory(@RequestParam String categoryName,@RequestParam String categoryDesc,Model m)
	{
		
		Category category = new Category();
		
		category.setCategoryName(categoryName);
		category.setCategoryDesc(categoryDesc);
		m.addAttribute("flag", flag);
			if(categoryDAO.addCategory(category))
			{
				m.addAttribute("msg", "Category created Successfully");
			}
			else
			{
				m.addAttribute("msg", "Could not create category");
			}
		
		return "redirect:/manage_categories";
	}
	
	@RequestMapping(value = "/category/edit/", method = RequestMethod.GET)
	public String editCategory(@RequestParam int categoryId, Model m)
	{
		flag=true;
		Category category = categoryDAO.getCategory(categoryId);
		//httpsession.setAttribute("selectedCategory", category);
		m.addAttribute("selectedCategory", category);
		m.addAttribute("flag", flag);
		return "category";
	}
	
	@RequestMapping(value="/category/update/",method=RequestMethod.POST)
	public String updateCategory(@RequestParam int categoryId,@RequestParam String categoryName,@RequestParam String categoryDesc,Model m)
	{
		flag=false;
		Category category=categoryDAO.getCategory(categoryId);
		category.setCategoryName(categoryName);
		category.setCategoryDesc(categoryDesc);
		
		categoryDAO.updateCategory(category);
		
		List<Category> listCategories=categoryDAO.listCategories();
		m.addAttribute("categorylist", listCategories);
		m.addAttribute("flag", flag);

		return "Category";
	}
	
	@RequestMapping(value = "/category/delete/", method = RequestMethod.GET)
	public String deleteCategory(@RequestParam int categoryId, Model m)
	{
		flag=false;
		Category category = categoryDAO.getCategory(categoryId);
		m.addAttribute("flag", flag);
		if(categoryDAO.deleteCategory(category))
		{
			m.addAttribute("msg", "Category deleted Successfully");
		}
		else
		{
			m.addAttribute("msg", "Could not delete category");
		}
	
	
	return "redirect:/manage_categories";
	}

}
