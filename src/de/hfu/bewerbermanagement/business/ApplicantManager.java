package de.hfu.bewerbermanagement.business;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import de.hfu.bewerbermanagement.model.Applicant;

//Fachlogik vom Bewerber
//exception handling
//sql statement von fachlogik trennen
public class ApplicantManager {
	
	// Exceptionhandling für den Bewerber
		@RequestMapping(value = {"/exceptionHandlingApplicant"}, method = RequestMethod.POST)
		public ModelAndView exceptionApplicant(
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

}
