package de.hfu.bewerbermanagement.user.controller;

import de.hfu.bewerbermanagement.business.ApplicantManager;
import de.hfu.bewerbermanagement.business.RecruiterManager;
import de.hfu.bewerbermanagement.user.dao.UserDao;
import de.hfu.bewerbermanagement.user.model.Applicant;
import de.hfu.bewerbermanagement.user.model.Recruiter;

import java.util.HashMap;
import java.util.Map;

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
			
				//Aufruf der Methode ExpressionApplicant
				RecruiterManager rm = new RecruiterManager();
				Map<String, Boolean> map = rm.expressionRecruiter(recruiter);
				
				if(map.get("name") && map.get("surname") && map.get("birthday") && map.get("enterprise") && map.get("position") && map.get("email") && map.get("password"))
				{
					System.out.println("Richtige Eingabe." + " Name: " + map.get("name") + " Nachname: " + map.get("surname") + " Geburtstag: " + map.get("birthday") + " Unternehmen: " + map.get("enterprise") + " Position: " + map.get("position") + " EMail: " + map.get("email") + " Passwort: " + map.get("password"));
					int counter = userDao.registerRecruiter(recruiter);
		
						if (counter > 0) {
							mv.addObject("msg", "User registration successful.");
							mv.setViewName("login");
						} else {
							mv.addObject("msg", "Error - check the console log");
							mv.setViewName("registrationRecruiter");
						}
				} else {
					System.out.println("Falsche Eingabe." + " Name: " + map.get("name") + " Nachname: " + map.get("surname") + " Geburtstag: " + map.get("birthday") + " Unternehmen: " + map.get("enterprise") + " Position: " + map.get("position") + " EMail: " + map.get("email") + " Passwort: " + map.get("password"));

					if(!map.get("name")) {
						mv.addObject("errorName", "Falsche Eingabe. Bitte mit einem Groﬂbuchstaben beginnen.");
					}
					if(!map.get("surname")) {
						mv.addObject("errorSurname", "Falsche Eingabe. Bitte mit einem Groﬂbuchstaben beginnen.");
					}
					if(!map.get("birthday")) {
						mv.addObject("errorBirthday", "Bitte geben Sie ein Datum ein.");
					}
					if(!map.get("enterprise")) {
						mv.addObject("errorEnterprise", "Falsche Eingabe. Bitte ein Unternehmen eintragen.");
					}
					if(!map.get("position")) {
						mv.addObject("errorPosition", "Falsche Eingabe. Bitte mit einem Groﬂbuchstaben beginnen.");
					}
					if(!map.get("email")) {
						mv.addObject("errorEmail", "Bitte eine richtige E-Mailadresse eingeben.");
					}
					if(!map.get("password")) {
						mv.addObject("errorPassword", "Das Passwort muss mind. 4 Zeichen enthalten.");
					}
					
					mv.addObject("recruiter",recruiter);
					mv.setViewName("registrationRecruiter");
							
				}
				
				return mv;
	}
	
	
	@RequestMapping(value = "/registerApplicant", method = RequestMethod.POST)
	public ModelAndView applicantRegistration(
			@RequestParam("password") String password, @RequestParam("email") String email,
			@RequestParam("userName") String userName, @RequestParam("userSurname") String userSurname, 
			@RequestParam("birthday") String birthday, @RequestParam("entryDate") String entryDate, 
			@RequestParam("subject") String subject, @RequestParam("specialization") String specialization, 
			@RequestParam("salary") String salary) {
		
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
		applicant.setSalary(salary);

		//Aufruf der Methode ExpressionApplicant
		ApplicantManager am = new ApplicantManager();
		Map<String, Boolean> map = am.expressionApplicant(applicant);
		
		if(map.get("name") && map.get("surname") && map.get("birthday") && map.get("entrydate") && map.get("subject") && map.get("specialization") && map.get("salary") && map.get("email") && map.get("password"))
		{
	
			int counter = userDao.registerApplicant(applicant);

				if (counter > 0) {
					mv.addObject("msg", "User registration successful.");
					mv.setViewName("login");
				} else {
					mv.addObject("msg", "Error - check the console log");
					mv.setViewName("registrationApplicant");
				}
		} else {
					
			if(!map.get("name")) {
				mv.addObject("errorName", "Falsche Eingabe. Bitte mit einem Groﬂbuchstaben beginnen.");
			}
			if(!map.get("surname")) {
				mv.addObject("errorSurname", "Falsche Eingabe. Bitte mit einem Groﬂbuchstaben beginnen.");
			}
			if(!map.get("birthday")) {
				mv.addObject("errorBirthday", "Bitte geben Sie ein Datum ein.");
			}
			if(!map.get("entrydate")) {
				mv.addObject("errorEntrydate", "Bitte geben Sie ein Datum ein.");
			}
			if(!map.get("subject")) {
				mv.addObject("errorSubject", "Falsche Eingabe. Bitte mit einem Groﬂbuchstaben beginnen.");
			}
			if(!map.get("specialization")) {
				mv.addObject("errorSpecialization", "Falsche Eingabe. Bitte mit einem Groﬂbuchstaben beginnen.");
			}
			if(!map.get("salary")) {
				mv.addObject("errorSalary", "Bitte eine mind. drei-stellige Zahl eingeben.");
			}
			if(!map.get("email")) {
				mv.addObject("errorEmail", "Bitte eine richtige E-Mailadresse eingeben.");
			}
			if(!map.get("password")) {
				mv.addObject("errorPassword", "Das Passwort muss mind. 4 Zeichen enthalten.");
			}
			mv.addObject("applicant", applicant);
			mv.setViewName("registrationApplicant");
		}
		
		return mv;
	}

	
}
