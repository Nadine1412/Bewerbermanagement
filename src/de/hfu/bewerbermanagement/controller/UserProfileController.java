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
	
	@RequestMapping(value = {"getOldProfile"}, method = RequestMethod.GET)
	public ModelAndView showOldProfil(HttpSession session) {
		
		ModelAndView mv = new ModelAndView();
		Applicant applicant = userDao.showApplicantProfile(session);
		if(applicant != null) {
			mv.addObject("applicant", applicant);
			mv.setViewName("changeProfile");
		} else {
			mv.addObject("msg", "Invalid user id or password.");
			mv.setViewName("login");
		}
		return mv;		
	}
	
	@RequestMapping(value = {"/updateProfile"}, method = RequestMethod.POST)
	public ModelAndView changeProfil(
			@RequestParam("userId") String userId,
			@RequestParam("password") String password, @RequestParam("email") String email,
			@RequestParam("userName") String userName, @RequestParam("userSurname") String userSurname,
//			@RequestParam("enterprise") String enterprise, @RequestParam("position") String position,
			@RequestParam("entryDate") String entryDate, @RequestParam("subject") String subject,
			@RequestParam("specialization") String specialization, @RequestParam("sallery") String sallery) {
		
		ModelAndView mv = new ModelAndView();
		
		Applicant bewerber = new Applicant();
		bewerber.setUserId(userId);
		bewerber.setPassword(password);
		bewerber.setEmail(email);
		bewerber.setUserName(userName);
		bewerber.setUserSurname(userSurname);
		bewerber.setEntryDate(entryDate);
		bewerber.setSubject(subject);
		bewerber.setSpecialization(specialization);
		bewerber.setSallery(sallery);
		
		int counter = userDao.changeProfil(bewerber);
		
		if(counter != 0) {
			mv.addObject("bewerber", bewerber);
			mv.setViewName("showProfile");
			
		} else {
			mv.addObject("msg", "Invalid update.");
			mv.setViewName("changeProfile");
		}
		return mv;		
	}
}
