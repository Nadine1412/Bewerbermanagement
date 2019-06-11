package de.hfu.bewerbermanagement.controller;

import de.hfu.bewerbermanagement.dao.UserDao;
import de.hfu.bewerbermanagement.model.Applicant;
import de.hfu.bewerbermanagement.model.Recruiter;

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

	@RequestMapping(value = "/registerRecruiter", method = RequestMethod.POST)
	public ModelAndView recruiterRegistration(
			@RequestParam("password") String password, @RequestParam("email") String email,
			@RequestParam("userName") String userName, @RequestParam("userSurname") String userSurname, 
			@RequestParam("birthday") String birthday, @RequestParam("enterprise") String enterprise, 
			@RequestParam("position") String position) {
		
		ModelAndView mv = new ModelAndView();

				Recruiter recruiter = new Recruiter();
				//recruiter.setUserId(userId);
				recruiter.setPassword(password);
				recruiter.setEmail(email);
				recruiter.setUserName(userName);
				recruiter.setUserSurname(userSurname);
				recruiter.setBirthday(birthday);
				recruiter.setEnterprise(enterprise);
				recruiter.setPosition(position);
			
				int counter = userDao.registerRecruiter(recruiter);
	
				if (counter > 0) {
					mv.addObject("msg", "User registration successful.");
					mv.setViewName("login");
					
				} else {
					mv.addObject("msg", "Error - check the console log");
					mv.setViewName("registrationRecruiter");
				}
	
				return mv;
	}
	
	@RequestMapping(value = "/registerApplicant", method = RequestMethod.POST)
	public ModelAndView candidateRegistration(
			@RequestParam("password") String password, @RequestParam("email") String email,
			@RequestParam("userName") String userName, @RequestParam("userSurname") String userSurname, 
			@RequestParam("birthday") String birthday, @RequestParam("entryDate") String entryDate, 
			@RequestParam("subject") String subject, @RequestParam("specialization") String specialization, 
			@RequestParam("sallery") String sallery) {
		
		ModelAndView mv = new ModelAndView();
		
		Applicant applicant = new Applicant();
//		bewerber.setUserId(userId);
		applicant.setPassword(password);
		applicant.setEmail(email);
		applicant.setUserName(userName);
		applicant.setUserSurname(userSurname);
		applicant.setBirthday(birthday);
		applicant.setEntryDate(entryDate);
		applicant.setSubject(subject);
		applicant.setSpecialization(specialization);
		applicant.setSallery(sallery);

		int counter = userDao.registerApplicant(applicant);

		if (counter > 0) {
			mv.addObject("msg", "User registration successful.");
			mv.setViewName("login");
		} else {
			mv.addObject("msg", "Error - check the console log");
			mv.setViewName("registrationApplicant");
		}

		
		return mv;
	}

	
}
