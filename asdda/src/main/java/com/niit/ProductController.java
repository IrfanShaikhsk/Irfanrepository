package com.niit;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.DAO.CategoryDAO;
import com.niit.DAO.ProductDAO;
import com.niit.model.Category;
import com.niit.model.Product;




@Controller
public class ProductController 
{
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	HttpSession httpsession;
	
	@RequestMapping(value="/product/save",method= RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product")Product product,Model m,@RequestParam(value="pimage")MultipartFile pImage)
	{
		productDAO.addProduct(product);
		
		Product prod = new Product();	//blank object which will be sent to Product.jsp
		m.addAttribute(prod);
		
		//------------------------------- I M A G E   I N S E R T I O N -------------------------------
		
		String path = "D:\\Project-1\\asdda\\src\\main\\webapp\\resources\\images\\";
		path = path + String.valueOf(product.getProductId()) + ".jpg";
		File filepath = new File(path);
		
		if(!pImage.isEmpty())
		{
			try
			{
				byte[] buffer=pImage.getBytes();
				FileOutputStream fos=new FileOutputStream(filepath);
				BufferedOutputStream bs=new BufferedOutputStream(fos);
				bs.write(buffer);
				bs.close();
			}
			catch(Exception e)
			{
				m.addAttribute("errorInfo",e.getMessage());
			}
		}
		else
		{
			m.addAttribute("errorInfo", "There is System Problem");
		}
		
		return "redirect:/manage_products";
	}
	
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public String displayProductPage(Model m)
	{
		
		List<Product> listProducts=productDAO.listProducts();
		m.addAttribute("listProducts", listProducts);
		m.addAttribute("categoryList", this.getAllCategories());
		return "ProductPage";
	}
		
	@RequestMapping(value="/productDesc/{productId}",method=RequestMethod.GET)
	public String showProductDesc(@PathVariable("productId")int productId,Model m)
	{
		Product product=productDAO.getProduct(productId);
		
		String categoryName=categoryDAO.getCategory(product.getCategoryId()).getCategoryName();
		m.addAttribute("ProductInfo",product);
		m.addAttribute("categoryName",categoryName);
		return "ProdDesc";
	}
	
	
	
	@RequestMapping(value="/product/edit/{productId}",method=RequestMethod.GET)
	public String editProduct(@PathVariable("productId")int productId,Model m)
	{
		Product product=productDAO.getProduct(productId);
		httpsession.setAttribute("selectedProduct",product);
		
		return "product";
		//return "redirect:/manage_products";
		
	}
	
	@RequestMapping(value="/product/delete/{productId}",method=RequestMethod.GET)
	public String deleteProduct(@PathVariable("productId")int productId,Model m)
	{
		Product product=productDAO.getProduct(productId);
		if(productDAO.deleteProduct(product))
		{
			m.addAttribute("msg", "Product deleted Successfully");
		}
		else
		{
			m.addAttribute("msg", "Could not delete product");
		}
		
		return "redirect:/manage_products";
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

