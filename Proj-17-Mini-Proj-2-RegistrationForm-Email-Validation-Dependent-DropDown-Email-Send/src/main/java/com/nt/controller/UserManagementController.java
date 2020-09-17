package com.nt.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.domain.UserAccounts;
import com.nt.domain.confirm.password.ConfirmPassword;
import com.nt.entities.UserAccountsEntity;
import com.nt.mail.EmailUtility;
import com.nt.service.UserManagementService;

@Controller
public class UserManagementController {

	@Autowired
	private UserManagementService service;

	@Autowired
	private EmailUtility emailUtil;

	@RequestMapping(value = "/loadForm")
	public String loadForm(Model model) {

		UserAccounts acc = new UserAccounts();
		model.addAttribute("userAcc", acc);// to laod the empty form

		// to load the conuntry in the first page
		Map<Integer, String> countriesMap = service.getAllCountries();
		model.addAttribute("countryMap", countriesMap);

		return "add_user_form";
	}

	@RequestMapping(value = "/getStates")
	@ResponseBody // to tell the controller that is a not a logial view name
	public Map<Integer, String> findStateByCountryId(@RequestParam("cid") Integer cid) {
		return service.getStatesByCountryId(cid);

	}

	@RequestMapping(value = "/getCities")
	@ResponseBody
	public Map<Integer, String> findCityByStateId(@RequestParam("sid") Integer sid) {
		return service.getCityByStateId(sid);
	}

	@RequestMapping(value = "/saveAll")
	public String saveUserAcc(@ModelAttribute("userAcc") UserAccounts ua, Model model) {
		UserAccountsEntity entity = new UserAccountsEntity();
		BeanUtils.copyProperties(ua, entity);
		boolean saveUserAcc = service.saveUserAcc(entity);

		// for sending mail check the condition
		if (saveUserAcc == true) {
			ua.setPazzword(entity.getPazzword()); // send the pass to the form bcoz passwoed is there in db it is not
													// comming from the form so pass is not present in form
			emailUtil.sendUserEmail(ua);
		}
		return "save_successful";
	}

	// for email validation

	@ResponseBody // to tell the controller that it is not going to return the
	@RequestMapping(value = "emailValidation")
	public String emailValidation(@PathParam("email") String email) {
		UserAccountsEntity emailValidation = service.emailValidation(email);
		if (emailValidation == null)
			return "UNIQUE";
		else
			return "DUPLICATE";
	}

	@RequestMapping(value = "/unlockAccountUsingEmail")//this mail will com from Google-mail
	public String unlockAccountByEmail(@PathParam("email") String email, Model model) {//

		ConfirmPassword cnf = new ConfirmPassword();
		model.addAttribute("emailId",email);
		model.addAttribute("xx",cnf);

		return "unlock_page";
	}


	@RequestMapping(value = "/finalLogin")
	public String FinalLogin(@ModelAttribute("xx") ConfirmPassword confirmPassword,@PathParam("email") String email,RedirectAttributes ra) {
		String tempPass = confirmPassword.getTempPass();
		boolean valid = service.isTempPassValid(tempPass);
		if(valid==false) {
			ra.addFlashAttribute("invalid","TempPassword is Invalid");
			return "redirect:/unlockAccountUsingEmail";
		}
		//for checking new password and confirm password is same or not
		String newPWD =  confirmPassword.getNewPass();
		String confPWD = confirmPassword.getConfirmPass();
		
		if(!(newPWD.equals(confPWD))) {
			ra.addFlashAttribute("same","New Pwd and Confirm pwd different!");
			return "redirect:/unlockAccountUsingEmail";
		}
		else {
			//activeStatus U- unlocked and update password
			System.out.println(email);
			UserAccountsEntity perticularUserToUpdate = service.emailValidation(email);
			perticularUserToUpdate.setActiveStatus('U');
			perticularUserToUpdate.setPazzword(newPWD);
			service.updateUserAccLockAndPass(perticularUserToUpdate);
			return "Finaly_loggedin";
		}
		
		
	}

}
