package com.niit.shopkartfrontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
@RequestMapping("/")
public String gotoHome()
{
	return "Home";
}
@RequestMapping("/Drop")
public String gotoDrop()
{
	return "Drop";
}

}






















