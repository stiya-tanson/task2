package com.uviqo.MicroRegister.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.uviqo.MicroRegister.model.User1;
import com.uviqo.MicroRegister.model.UserRepo;

@RestController
public class RegistrationController {
	
	RestTemplate restTemplate= new RestTemplate();
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder bCryptEncoder;
	
	
	@RequestMapping("/")
	public String test() {
		return "hey";
	}
	
	
	@RequestMapping("/registerportal/{userName}/{Password}")
	public String registerUser(@PathVariable("userName") String username,
			@PathVariable("Password") String password) {
	
		System.out.println("inside registration");
		
		String pword=bCryptEncoder.encode(password);
		User1 u=new User1();
		u.setUsername(username);
		u.setPassword(pword);
		try {
		userRepo.save(u);
		}catch (Exception e) { 
			System.out.println("Something went wrong in registration");
			return "failed";
		}
		return "succes";
	}
}
