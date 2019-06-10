package de.hfu.bewerbermanagement.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import de.hfu.bewerbermanagement.dao.UserDao;
import de.hfu.bewerbermanagement.dao.UserDaoImpl;
import de.hfu.bewerbermanagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserLoginController {
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView userLogin(@RequestParam("inputEmail") String email, @RequestParam("inputPassword") String password, HttpSession session) {
				
		ModelAndView mv = new ModelAndView();
		
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		
		//Selektierung des Nachnamens (Nadine Jakob 07.06.2019)
		String name = userDao.loginUser(user);

		//session Variable setzen
		session.setAttribute("userEmail", email);

		if(name != null) {
			mv.addObject("msg", "Willkommen Herr / Frau " + name + ", Sie haben sich erfolgreich eingeloggt.");
			mv.setViewName("overviewBewerber");
		} else {
			mv.addObject("msg", "Invalid user id or password.");
			mv.setViewName("login");
		}
		return mv;
		
	}
}
