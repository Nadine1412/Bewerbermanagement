package de.hfu.bewerbermanagement.user.controller;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserLogoutController {

	// Logout des Users
	@RequestMapping(value="/logout",method = RequestMethod.GET)
    public ModelAndView logout(HttpSession session){
		ModelAndView mv = new ModelAndView();

		session.invalidate();
      
		// Löschen des lokalen Skill-Files
      	File file = new File(System.getProperty("user.dir") + "/skills.json"); 
      	file.delete();
		
      	mv.addObject("msg", "Erfolgreich ausgeloggt.");
		mv.setViewName("decision");
		return mv;
    }
}
