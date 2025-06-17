package com.aloha.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.aloha.spring.dto.User;
import com.aloha.spring.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/join")
	public void join(@ModelAttribute User user) {
		
	}
	
	@PostMapping("/join")
	public String joinPOST(
			@Validated @ModelAttribute User user,
			BindingResult bindingResult
	) throws Exception {
		// 유효성 검사
		if( bindingResult.hasErrors() ) {
			return "join";
		}
		
		boolean result = userService.insert(user);
		if( result ) 
			return "redirect:/";
		else
			return "join";
	}

}





