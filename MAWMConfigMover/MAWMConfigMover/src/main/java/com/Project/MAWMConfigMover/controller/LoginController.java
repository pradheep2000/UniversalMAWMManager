package com.Project.MAWMConfigMover.controller;

import com.Project.MAWMConfigMover.ClientServiceImpl.MAWMClientService;
import com.Project.MAWMConfigMover.Clients.MAWMClients;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
public class LoginController {

	public List<MAWMClients> listClients = new ArrayList();
	public List<String> clients = new ArrayList<>();

	@Autowired
	private MAWMClientService mawmClientService;


	@GetMapping(value = "/login")
	public String login(Model model) {

		List<MAWMClients> listClients = mawmClientService.findAll();
		for (MAWMClients list : listClients) {
			if(!clients.contains(list.getClientCode()))
				clients.add(list.getClientCode());
		}
		model.addAttribute("listClients", clients);
		return "login";
	}

	@Autowired
	private Environment environment;

	@PostMapping(value = "/displayGoLiveSites")
	public String Display(Model model, @RequestParam String userId, @RequestParam String password, @RequestParam String clientCode){
		String pwd = environment.getProperty("password");
		List<MAWMClients> listClients = mawmClientService.findAll();
		for (MAWMClients list : listClients) {
			if(!clients.contains(list.getClientCode()))
				clients.add(list.getClientCode());
		}
		if(userId.contains("@manh.com")) {
			if (password.equals(pwd)) {
				model.addAttribute("allSites", listClients);
				model.addAttribute("mawmclients", new MAWMClients());
				String jsonData = new Gson().toJson(listClients);
				model.addAttribute("jsonData", jsonData);
				//sleep(1);

				return "Welcome";
			} else {
				model.addAttribute("errorMsg", "Invalid Password");
				model.addAttribute("listClients", clients);
				return "login";
			}
		}
		model.addAttribute("errorMsg", "Unauthorized access");
		model.addAttribute("listClients", clients);
		return "login";
	}

}
