package de.hfu.bewerbermanagement.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import de.hfu.bewerbermanagement.business.ApplicantManager;
import de.hfu.bewerbermanagement.business.RecruiterManager;
import de.hfu.bewerbermanagement.dao.UserDao;
import de.hfu.bewerbermanagement.model.Applicant;
import de.hfu.bewerbermanagement.model.Recruiter;
import de.hfu.bewerbermanagement.model.Skills;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserProfileController {
	
	//private ArrayList<Bewerber> bewerberList = new ArrayList<Bewerber>();
	
	@Autowired
	private UserDao userDao;
	
	//Profildaten von der Datenbank(dao) an den View weitergeben
	@RequestMapping(value = {"getProfile"}, method = RequestMethod.GET)
	public ModelAndView showApplicantProfile(HttpSession session) {
		
		String email = (String) session.getAttribute("userEmail");
		
		ModelAndView mv = new ModelAndView();
		if((boolean) session.getAttribute("isApplicant"))
		{
			//session Variable setzen
			int a_id = (int) session.getAttribute("a_id");
			Applicant applicant = userDao.showApplicantProfile(email);
			Skills skills =  userDao.oldSkills(a_id);
					
			if(applicant != null) {
				mv.addObject("applicant", applicant);
				
				//Aufrufen der F‰higkeiten
				if(skills != null) {
					String programmingStr = skills.getProgrammingLanguage().toString();
					String officeStr = skills.getOffice().toString();
					String languageStr = skills.getLanguage().toString();
					
					String subProgramming = programmingStr.substring(1, programmingStr.length()-1);
					String subOffice = officeStr.substring(1, officeStr.length()-1);
					String subLanguage = languageStr.substring(1, languageStr.length()-1);
							
					mv.addObject("programmingLanguage", subProgramming);
					mv.addObject("office", subOffice);
					mv.addObject("language", subLanguage);
				}
				mv.setViewName("showApplicantProfile");
			} else {
				mv.addObject("msg", "Invalid user id or password.");
				mv.setViewName("login");
			}
		}
		else {
			Recruiter recruiter = userDao.showRecruiterProfile(email);
			if(recruiter != null) {
				mv.addObject("recruiter", recruiter);
				mv.setViewName("showRecruiterProfile");
			} else {
				mv.addObject("msg", "Invalid user id or password.");
				mv.setViewName("login");
			}
		}
		return mv;		
	}
	
	//Alte Profildaten von der Datenbank(dao) an den View weitergeben
	@RequestMapping(value = {"getOldProfile"}, method = RequestMethod.GET)
	public ModelAndView showOldProfil(HttpSession session) {
		
		ModelAndView mv = new ModelAndView();
		if((boolean) session.getAttribute("isApplicant"))
		{
			Applicant applicant = userDao.showApplicantProfile(session);
			if(applicant != null) {
				mv.addObject("applicant", applicant);
				mv.setViewName("changeApplicantProfile");
			} else {
				mv.addObject("msg", "Invalid user id or password.");
				mv.setViewName("login");
			}
		}
		else {
			Recruiter recruiter = userDao.showRecruiterProfile(session);
			if(recruiter != null) {
				mv.addObject("recruiter", recruiter);
				mv.setViewName("changeRecruiterProfile");
			} else {
				mv.addObject("msg", "Invalid user id or password.");
				mv.setViewName("login");
			}
		}
		return mv;		
	}
	
	// Aktualisiertes Bewerber-Profil vom View an die Datenbank (dao) posten
	@RequestMapping(value = {"/updateApplicantProfile"}, method = RequestMethod.POST)
	public ModelAndView changeApplicantProfil(
			@RequestParam("userId") String userId,
			@RequestParam("password") String password, @RequestParam("email") String email,
			@RequestParam("userName") String userName, @RequestParam("userSurname") String userSurname,
			@RequestParam("birthday") String birthday, @RequestParam("entryDate") String entryDate, 
			@RequestParam("subject") String subject, @RequestParam("specialization") String specialization, 
			@RequestParam("sallery") String sallery) {
		
		ModelAndView mv = new ModelAndView();
		
		Applicant applicant = new Applicant();
		applicant.setUserId(userId);
		applicant.setPassword(password);
		applicant.setEmail(email);
		applicant.setBirthday(birthday);
		applicant.setUserName(userName);
		applicant.setUserSurname(userSurname);
		applicant.setEntryDate(entryDate);
		applicant.setSubject(subject);
		applicant.setSpecialization(specialization);
		applicant.setSallery(sallery);
		
		//Aufruf der Methode ExpressionApplicant
				ApplicantManager am = new ApplicantManager();
				Map<String, Boolean> map = am.expressionApplicant(applicant);
				
				if(map.get("name") && map.get("surname") && map.get("birthday") && map.get("entrydate") && 
						map.get("subject") && map.get("specialization") && map.get("sallery") && map.get("email") && 
						map.get("password"))
				{
					int counter = userDao.changeApplicantProfile(applicant);

						if (counter > 0) {
							mv.addObject("msg", "Profil-ƒnderung erfolgreich.");
							mv.addObject("applicant", applicant);
							mv.setViewName("showApplicantProfile");
						} else {
							mv.addObject("msg", "Error - check the console log");
							mv.setViewName("changeApplicantProfile");
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
					if(!map.get("sallery")) {
						mv.addObject("errorSallery", "Bitte eine mind. drei-stellige Zahl eingeben.");
					}
					if(!map.get("email")) {
						mv.addObject("errorEmail", "Bitte eine richtige E-Mailadresse eingeben.");
					}
					if(!map.get("password")) {
						mv.addObject("errorPassword", "Das Passwort muss mind. 4 Zeichen enthalten.");
					}
					mv.addObject("applicant", applicant);
					mv.setViewName("changeApplicantProfile");
				}
				
				return mv;
		}
	
	// Aktualisiertes Personaler-Profil vom View an die Datenbank(dao) posten
	@RequestMapping(value = {"/updateRecruiterProfile"}, method = RequestMethod.POST)
	public ModelAndView changeRecruiterProfil(
			@RequestParam("userId") String userId,
			@RequestParam("password") String password, @RequestParam("email") String email,
			@RequestParam("userName") String userName, @RequestParam("userSurname") String userSurname,
			@RequestParam("enterprise") String enterprise, @RequestParam("position") String position,
			@RequestParam("birthday") String birthday) {
		
		ModelAndView mv = new ModelAndView();
		
		Recruiter recruiter = new Recruiter();
		recruiter.setUserId(userId);
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
		
		if(map.get("name") && map.get("surname") && map.get("birthday") && map.get("enterprise") && 
				map.get("position") && map.get("email") && map.get("password"))
		{
			int counter = userDao.changeRecruiterProfile(recruiter);

				if (counter > 0) {
					mv.addObject("msg", "Profil-ƒnderung erfolgreich.");
					mv.addObject("recruiter", recruiter);
					mv.setViewName("showRecruiterProfile");
				} else {
					mv.addObject("msg", "Error - check the console log");
					mv.setViewName("changeRecruiterProfile");
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
			mv.setViewName("changeRecruiterProfile");
					
		}
		
		return mv;
	}
	
}
