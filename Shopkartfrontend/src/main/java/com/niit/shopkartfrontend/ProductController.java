package com.niit.shopkartfrontend;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.niit.shopkartbackend.dao.CategoryDAO;
import com.niit.shopkartbackend.dao.ProductDAO;
import com.niit.shopkartbackend.model.Category;
import com.niit.shopkartbackend.model.FileUtil;
import com.niit.shopkartbackend.model.Product;



@Controller
public class ProductController {
	
	String path="F:/workspace/Shopkartfrontend/src/main/webapp/resources/images/";

	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private Product product;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value="/Product",method=RequestMethod.GET)
	public String productlist(Model model){
		
		Product product= new Product();
		model.addAttribute("product", product);
		System.out.println(this.categoryDAO.list());
		model.addAttribute("categoryList", this.categoryDAO.list());
		return "Product";
	}
	
	@RequestMapping(value="/Product",method=RequestMethod.POST)
	public String addproduct(@ModelAttribute("product") Product product){
		//ModelAndView mv=new ModelAndView("/ProductList");
		
	 	System.out.println("category");
		Category category=categoryDAO.getByName(product.getCategory().getName());
		System.out.println(category);
		product.setCategory(category); 
		
		productDAO.saveOrUpdate(product);
		
		MultipartFile file=product.getFile();
		FileUtil.upload(path, file, product.getId()+".jpg");
		return "redirect:/ProductList";
	}
	

	@RequestMapping(value="/ProductList")
	public String prdlist(Model model){
		Gson gson = new Gson();
	List<Product> prctlist=productDAO.list();
	String prct = gson.toJson(prctlist);
	model.addAttribute("prct", prct);
	return "Producttable";
	}
		
	
	@RequestMapping(value = "/editprd")
	public String editprd(HttpServletRequest request, Model model,RedirectAttributes redirectAttributes) {
		int id=Integer.parseInt(request.getParameter("id"));
		model.addAttribute("categoryList", this.categoryDAO.list());
		product=productDAO.get(id);
		System.out.println("editprd");
		model.addAttribute("product", product);
			return "/Product";
	}

	//To delete  a product
	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	public String remove(HttpServletRequest request, Model model,RedirectAttributes redirectAttributes)throws Exception{
		int id=Integer.parseInt(request.getParameter("id"));
			productDAO.delete(id);
		
				return "redirect:/ProductList";
	}
	
}


	
