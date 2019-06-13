package de.hfu.bewerbermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import de.hfu.bewerbermanagement.dao.UserDao;
import de.hfu.bewerbermanagement.model.Skills;

@Controller
public class UserSkillsController {
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value = "/skills", method = RequestMethod.POST)
	public ModelAndView userSkills(
			@RequestParam("java") String java, @RequestParam("javascript") String javascript) {
		
		ModelAndView mv = new ModelAndView();
		
		Skills skills = new Skills();
		skills.setJava(java);
		skills.setJavascript(javascript);
		
int counter = userDao.userSkills(skills);
		
		if (counter > 0) {
			mv.addObject("msg", "File Upload successful.");
			mv.setViewName("login");
			
		} else {
			mv.addObject("msg", "Error - check the console log");
			mv.setViewName("fileUpload");
		}
		return mv;
	}
}
