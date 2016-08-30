package com.niit.shopkartfrontend;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.niit.shopkartbackend.dao.SupplierDAO;
import com.niit.shopkartbackend.model.Supplier;





@Controller
public class SupplierController {

	@Autowired
	private SupplierDAO supplierDAO;
	@Autowired
	private Supplier supplier;
	
	@RequestMapping(value="/Supplier",method=RequestMethod.GET)
	public String supplierlist(Model model){
		model.addAttribute("supplier", supplier);
		return "Supplier";
	}
	
	@RequestMapping(value="/Supplier",method=RequestMethod.POST)
	public String addsupplier(@ModelAttribute("supplier") Supplier supplier){
		supplierDAO.saveOrUpdate(supplier);
		return "redirect:/SupplierList";
	}
	
	@RequestMapping(value="/SupplierList")
	public String suplist(Model model){
		Gson gson = new Gson();
	List<Supplier> sup=supplierDAO.list();
	String suplr = gson.toJson(sup);
	model.addAttribute("suplr", suplr);
	return "Suppliertable";
	}
	
	//To delete  a supplier
	@RequestMapping(value = "/deletesup", method = RequestMethod.GET)
	public String deletesup(HttpServletRequest request, Model model,RedirectAttributes redirectAttributes)throws Exception{
		int id=Integer.parseInt(request.getParameter("id"));
			supplierDAO.delete(id);
		
				return "redirect:/SupplierList";
	}
	
	//To edit supplier
		@RequestMapping(value = "/editsup")
		public String editsup(HttpServletRequest request, Model model,RedirectAttributes redirectAttributes) {
			int id=Integer.parseInt(request.getParameter("id"));
			supplier=supplierDAO.get(id);
			model.addAttribute("supplier", supplier);
				return "/Supplier";
		}
	
	}


	
