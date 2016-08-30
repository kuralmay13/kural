package com.niit.shopkartfrontend;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.niit.shopkartbackend.dao.CategoryDAO;
import com.niit.shopkartbackend.model.Category;

@Controller
public class CategoryController {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private Category category;
	
	
	//Mapping for the category page
	@RequestMapping(value="/Category",method=RequestMethod.GET)
	public String categorylist(Model model){
		Category category= new Category();
		model.addAttribute(category);
		return "Category";
	}
	
	//Mapping for the add category page
	@RequestMapping(value="/Category",method=RequestMethod.POST)
	public String category(Category category,Model model,RedirectAttributes redirectAttributes){
		categoryDAO.saveOrUpdate(category);
		return "redirect:/CategoryList";
	}
	
	
	//to view the categories
	@RequestMapping(value="/CategoryList")
	public String catlist(Model model){
		Gson gson = new Gson();
	List<Category> list=categoryDAO.list();
	String catlis = gson.toJson(list);
	model.addAttribute("catlis", catlis);
	return "Categorytable";
	}
	
	//To delete  a category
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request, Model model,RedirectAttributes redirectAttributes)throws Exception{
		int id=Integer.parseInt(request.getParameter("id"));
			categoryDAO.delete(id);
		
				return "redirect:/CategoryList";
	}
	
	
	//To Edit a category
	@RequestMapping(value = "/editcat")
	public String edit(HttpServletRequest request, Model model,RedirectAttributes redirectAttributes) {
		int id=Integer.parseInt(request.getParameter("id"));
		category=categoryDAO.get(id);
		System.out.println("editcat");
		model.addAttribute("category", category);
			return "/Category";
		
	}
	
	@RequestMapping(value="/dell")
	public String delllist(Model model){
		Gson gson = new Gson();
	List<Category> delllist=categoryDAO.list();
	String delllis = gson.toJson(delllist);
	model.addAttribute("delllis", delllis);
	return "Dell";
	}
	
	}




	
