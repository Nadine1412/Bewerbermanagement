package de.hfu.bewerbermanagement.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import de.hfu.bewerbermanagement.dao.UserDao;
import de.hfu.bewerbermanagement.model.Applicant;
import de.hfu.bewerbermanagement.model.Recruiter;

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
		
		ModelAndView mv = new ModelAndView();
		if((boolean) session.getAttribute("isApplicant"))
		{
			Applicant applicant = userDao.showApplicantProfile(session);
			if(applicant != null) {
				mv.addObject("applicant", applicant);
				mv.setViewName("showApplicantProfile");
			} else {
				mv.addObject("msg", "Invalid user id or password.");
				mv.setViewName("login");
			}
		}
		else {
			Recruiter recruiter = userDao.showRecruiterProfile(session);
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
		
		int counter = userDao.changeApplicantProfile(applicant);
		
		if(counter != 0) {
			mv.addObject("applicant", applicant);
			mv.setViewName("showApplicantProfile");
			
		} else {
			mv.addObject("msg", "Invalid update.");
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

		
		int counter = userDao.changeRecruiterProfile(recruiter);
		
		if(counter != 0) {
			mv.addObject("recruiter", recruiter);
			mv.setViewName("showRecruiterProfile");
			
		} else {
			mv.addObject("msg", "Invalid update.");
			mv.setViewName("changeRecruiterProfile");
		}
		return mv;		
	}
	
}
