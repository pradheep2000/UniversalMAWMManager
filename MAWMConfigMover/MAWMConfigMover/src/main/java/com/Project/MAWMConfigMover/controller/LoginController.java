package com.Project.MAWMConfigMover.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@GetMapping(value = "/login")
	public String login()
	{
		return "login";
	}
	@Autowired
	private Environment environment;

	@PostMapping(value = "/displayGoLiveSites")
	public String Display(Model model, @RequestParam String userId, @RequestParam String password, @RequestParam String clientCode){
		String usrName = environment.getProperty("userid");
		String pwd = environment.getProperty("password");

		if(userId.equals(usrName + "@manh.com"))
		{
			if (password.equals(pwd))
			{
				return "Welcome";
			}
			else
			{
				model.addAttribute("errorMsg","Invalid Password");
				return "login";
			}
		}
		model.addAttribute("errorMsg","Unauthorized access");
		return "login";
	}
}
