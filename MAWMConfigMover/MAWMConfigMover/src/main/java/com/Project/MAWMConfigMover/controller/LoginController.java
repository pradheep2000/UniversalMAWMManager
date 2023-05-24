package com.Project.MAWMConfigMover.controller;

import com.Project.MAWMConfigMover.ClientServiceImpl.ClientServiceImpl;
import com.Project.MAWMConfigMover.ClientServiceImpl.ViavService;
import com.Project.MAWMConfigMover.Clients.Clients;
import com.Project.MAWMConfigMover.Clients.Viav;
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

	public List<Clients> listClients = new ArrayList();
	@Autowired
	private ClientServiceImpl clientService;

	@Autowired
	private ViavService viavService;

	@GetMapping(value = "/login")
	public String login(Model model) {
		List<Clients> listClients = clientService.findAll();
		System.out.println(listClients);
		model.addAttribute("listClients", listClients);
		model.addAttribute("wmclients", new Clients());
		return "login";
	}

	@Autowired
	private Environment environment;

	@PostMapping(value = "/displayGoLiveSites")
	public String Display(Model model, @RequestParam String userId, @RequestParam String password, @RequestParam String clientCode){
		String pwd = environment.getProperty("password");
		if(userId.contains("@manh.com")) {
			if (password.equals(pwd)) {
				List<Viav> allSites = viavService.getAllSites();
				model.addAttribute("allSites", allSites);
				String jsonData = new Gson().toJson(allSites);
				model.addAttribute("jsonData", jsonData);
				//sleep(1);

				return "Welcome";
			} else {
				model.addAttribute("errorMsg", "Invalid Password");
				return "login";
			}
		}
		model.addAttribute("errorMsg", "Unauthorized access");
		return "login";
	}

	@GetMapping("/livesites")
	public List<Viav> getAllSites() {
		return viavService.getAllSites();
	}


}
