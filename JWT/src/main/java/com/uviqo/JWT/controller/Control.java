package com.uviqo.JWT.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Control {

@RequestMapping("/sample")
public String hello() {
	return "sample";
}

@RequestMapping("/test")
public String hey() {
	return "test";
}


@RequestMapping("/signout")
public String log(HttpServletRequest request, HttpServletResponse response, Model model) {
	//To signout, we have to destroy the existing cookie by setting MaxAge to 0 seconds
	Cookie cookie = null;
	//read all cookies to Cookie[] array
	Cookie[] cookies = request.getCookies();
	try {
	for (int i = 0; i < cookies.length; i++) {
		cookie=cookies[i];
		
		//find the Authorization cookie
	    if ("Authorization".equals(cookie.getName())) {
	    	 cookie.setMaxAge(0);
	    	 response.addCookie(cookie);
	    	 System.out.println("cookie destroyed");
	    	 //Go to login page after destroying cookie
	    	 model.addAttribute("error", "Logged out successfully");
	    	 return "login";
	    }
	  }
	}catch(Exception e) {
		System.out.println("Cookie not present");
	}
	model.addAttribute("error", "Logged out");
	return "login";
}

}
