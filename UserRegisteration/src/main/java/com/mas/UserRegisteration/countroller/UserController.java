package com.mas.UserRegisteration.countroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.mas.UserRegisteration.domin.City;
import com.mas.UserRegisteration.domin.Country;
import com.mas.UserRegisteration.domin.State;
import com.mas.UserRegisteration.domin.User;
import com.mas.UserRegisteration.service.UserService;

@Controller
public class UserController {
        //--------------not usefull from maksood batchmate project batch----------------------------
	@Autowired
	private UserService userService;
		
	@RequestMapping("/addUserForm")
	public String loadForm(Model model) {
		User user = new User();
		model.addAttribute("loadForm",user);
		return "addUserForm";

	}
	@GetMapping(value ="/getAllEmaildetails")
	public Boolean getEmailDetails(String email) {
		 Boolean checkEmail = userService.checkEmail(email);
		return checkEmail;
		
	}
	
	@GetMapping(value ="/getAllcountrydetails")
	public List<Country> getAllCountrys() {
		 List<Country> allCountry = userService.getAllCountry();
		return allCountry;
		
	}
	
	@GetMapping(value ="/getAllStateDetails")
	public List<State> getAllStates(@RequestParam("countryId") Integer countryId) {
		  List<State> allCountry = userService.getAllState(countryId);
		return allCountry;
		
	}
	
	@GetMapping(value ="/getAllCityDetails")
	public List<City> getAllCitys(@RequestParam ("stateId") Integer stateId) {
		List<City> allCity = userService.getAllCity(stateId);
		return allCity;
		
	}
	@PostMapping("/addUser")
	public String saveUserDetail(@RequestBody User user) {
		Boolean saveUser = userService.saveUser(user);
		return "reg";

	}

}
