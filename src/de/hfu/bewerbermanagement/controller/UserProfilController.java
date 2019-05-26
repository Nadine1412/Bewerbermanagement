package de.hfu.bewerbermanagement.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import de.hfu.bewerbermanagement.dao.UserDao;
import de.hfu.bewerbermanagement.model.Bewerber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserProfilController {
	
	//private ArrayList<Bewerber> bewerberList = new ArrayList<Bewerber>();
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value = {"getProfile"}, method = RequestMethod.GET)
	public ModelAndView showProfil(HttpSession session) {
		
		ModelAndView mv = new ModelAndView();
		Bewerber bewerber = userDao.showProfil(session);
		if(bewerber != null) {
			mv.addObject("bewerber", bewerber);
			mv.setViewName("showProfile");
		} else {
			mv.addObject("msg", "Invalid user id or password.");
			mv.setViewName("login");
		}
		return mv;		
	}
}
