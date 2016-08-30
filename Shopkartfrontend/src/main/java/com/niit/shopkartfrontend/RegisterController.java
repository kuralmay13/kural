package com.niit.shopkartfrontend;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shopkartbackend.dao.UserDAO;
import com.niit.shopkartbackend.model.User;

@Controller
public class RegisterController {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private User user;
	
	@RequestMapping(value="Register",method=RequestMethod.GET)
	public ModelAndView register(){
	ModelAndView mv=new ModelAndView("Register");
	mv.addObject("user",new User());
	return mv;
	}
	
	@RequestMapping(value="Register",method=RequestMethod.POST)
	public ModelAndView register(@Valid@ModelAttribute ("user") User user,BindingResult result) {
		ModelAndView mv=new ModelAndView();
		  if(result.hasErrors()){
              System.out.println("It has errors");
              mv=new ModelAndView("Register");
              return mv;
          }
		userDAO.saveOrUpdate(user);
		mv=new ModelAndView("Login");
		mv.addObject("RegSuccess","Successfully registered..Login with valid credentials");
	   return mv;
	}
	
	@RequestMapping(value="Login",method=RequestMethod.GET)
	public ModelAndView login(){
	ModelAndView mv=new ModelAndView("Login");
	mv.addObject("user", user);
	return mv;
	}
	
	@RequestMapping(value="Login",method=RequestMethod.POST)
	public ModelAndView log(@RequestParam("username")String username,@RequestParam("password")String password,HttpSession session){
		
	ModelAndView mv=new ModelAndView();
	/*mv.addObject("user", user);*/
	
	boolean isValidUser=userDAO.isValidUser(username, password);
	if(isValidUser==true)
	{
		user=userDAO.get(username);
		session.setAttribute("logUser", user.getUsername());
		if(user.getRole().equals("ROLE_ADMIN"))
		{
			mv=new ModelAndView("Admin");
			mv.addObject("isAdmin","true");
			mv.addObject("successMsg","Welcome Admin...");
			return mv;
		}
		else
		{
			mv=new ModelAndView("Home");
			mv.addObject("isAdmin","false");
			mv.addObject("loginMsg","Loggedin Successfully");
			return mv;
		}
		
	}
	else
	{
		mv=new ModelAndView("Login");
	mv.addObject("error","Invalid Credentials...");
	return mv;
	}
	}
	
	@RequestMapping(value="Logoutuser",method=RequestMethod.GET)
	public ModelAndView logout1(HttpSession session,HttpServletRequest request){
	ModelAndView mv=new ModelAndView("Home");
	session.invalidate();
	session=request.getSession(true);
	mv.addObject("logoutMsg","Loggedout Successfully");
    return mv;
	}
	
	@RequestMapping(value="Home",method=RequestMethod.GET)
	public ModelAndView home(){
	ModelAndView mv=new ModelAndView("Home");
		return mv;
	}
	
}
