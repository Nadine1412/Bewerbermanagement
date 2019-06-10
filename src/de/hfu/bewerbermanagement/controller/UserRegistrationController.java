package de.hfu.bewerbermanagement.controller;

import de.hfu.bewerbermanagement.dao.UserDao;
import de.hfu.bewerbermanagement.model.Bewerber;
//import org.bewerbermanagement.model.Personaler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserRegistrationController {

	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView userRegistration(
			@RequestParam("password") String password, @RequestParam("email") String email,
			@RequestParam("userName") String userName, @RequestParam("userSurname") String userSurname,
//			@RequestParam("enterprise") String enterprise, @RequestParam("position") String position,
			@RequestParam("entryDate") String entryDate, @RequestParam("subject") String subject,
			@RequestParam("specialization") String specialization, @RequestParam("sallery") String sallery) {
		
		ModelAndView mv = new ModelAndView();

//		//if (enterprise =="") {
//
//			Personaler personaler = new Personaler();
//			personaler.setUserId(userId);
//			personaler.setPassword(password);
//			personaler.setEmail(email);
//			personaler.setUserName(userName);
//			personaler.setUserSurname(userSurname);
//			personaler.setEnterprise(enterprise);
//			personaler.setEnterprise(enterprise);
//		
//			int counter = userDao.registerPersonaler(personaler);
//
//			if (counter > 0) {
//				mv.addObject("msg", "User registration successful.");
//
//			} else {
//				mv.addObject("msg", "Error - check the console log");
//			}
//
//			mv.setViewName("registration");
//			return mv;
//		
////		} else {
		
		Bewerber bewerber = new Bewerber();
//		bewerber.setUserId(userId);
		bewerber.setPassword(password);
		bewerber.setEmail(email);
		bewerber.setUserName(userName);
		bewerber.setUserSurname(userSurname);
		bewerber.setEntryDate(entryDate);
		bewerber.setSubject(subject);
		bewerber.setSpecialization(specialization);
		bewerber.setSallery(sallery);

		int counter = userDao.registerBewerber(bewerber);

		if (counter > 0) {
			mv.addObject("msg", "User registration successful.");
			mv.setViewName("login");
		} else {
			mv.addObject("msg", "Error - check the console log");
			mv.setViewName("registration");
		}

		
		return mv;
	}

}
