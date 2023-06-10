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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
		String clntcd = clientCode.substring(0,clientCode.length() - 1);
		List<MAWMClients> listClients = mawmClientService.fetchDataByClientcode(clntcd);
		System.out.println(listClients);
		for (MAWMClients list : listClients) {
			if(!clients.contains(list.getClientCode()))
				clients.add(list.getClientCode());
		}
		if(userId.contains("@manh.com")) {
			if (password.equals(pwd)) {
				model.addAttribute("allSites", listClients);
				model.addAttribute("mawmclients", new MAWMClients());
				model.addAttribute("clientCode",clientCode);
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

	@PostMapping(value = "/addFacility")
	public String addFacility(Model model, @RequestParam String clientCode, @RequestParam String org, @RequestParam String facility, @RequestParam String longitude, @RequestParam String latitude, @RequestParam String goLiveDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date date = null;
		try {
			date = sdf.parse(goLiveDate);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		System.out.println(date);


		MAWMClients newClient = new MAWMClients(clientCode, org, facility, longitude, latitude, date);
		mawmClientService.saveSite(newClient);
		//return "redirect:/displayGoLiveSites";

		String clntcd = clientCode.substring(0,clientCode.length() - 1);
		List<MAWMClients> listClients = mawmClientService.fetchDataByClientcode(clientCode);
		//System.out.println(clientCode + "hi");
		for (MAWMClients list : listClients) {
			if(!clients.contains(list.getClientCode()))
				clients.add(list.getClientCode());
		}
		model.addAttribute("allSites", listClients);
		model.addAttribute("mawmclients", new MAWMClients());
		String jsonData = new Gson().toJson(listClients);
		model.addAttribute("jsonData", jsonData);
		return "Welcome";
	}

	@PostMapping(value = "/configCodeMover")
	public String configCodeMover(Model model, @RequestParam String Source, @RequestParam String Destination, @RequestParam String action) {
		model.addAttribute("source", Source);
		model.addAttribute("action", action);
		System.out.println("action: " + action);
		System.out.println("MAWM: source: " + Source + " action: " + action + " destination: " + Destination);
		return "ConfigMover";
	}

}
