package de.hfu.bewerbermanagement.controller;

import javax.servlet.http.HttpSession;

import de.hfu.bewerbermanagement.dao.UserDao;
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
	public ModelAndView userLogin(@RequestParam("inputEmail") String email, @RequestParam("inputPassword") String password) {
				
		ModelAndView mv = new ModelAndView();
		
		User user = new User();
		user.setEmail(email);
		//user.setUserId(userId);
		user.setPassword(password);

		String name = userDao.loginUser(user);

		//session Variable setzen
		//session.setAttribute("userId", userId);
	
		if(name != null) {
			mv.addObject("msg", "Welcome " + name + ", You have successfully logged in.");
		//	mv.setViewName("welcome");
			mv.setViewName("overviewBewerber");
		} else {
			mv.addObject("msg", "Invalid user id or password.");
			mv.setViewName("login");
		}
		return mv;
		
	}
}
