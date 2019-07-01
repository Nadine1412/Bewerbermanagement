package de.hfu.bewerbermanagement.user.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import de.hfu.bewerbermanagement.skills.dao.SkillsDao;
import de.hfu.bewerbermanagement.skills.model.Skills;
import de.hfu.bewerbermanagement.user.dao.UserDao;
import de.hfu.bewerbermanagement.user.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class UserLoginController {

	@Autowired
	private UserDao userDao;
	@Autowired
	private SkillsDao skillsDao;

	@RequestMapping(value = "/view/jsp/user/login", method = RequestMethod.POST)
	public ModelAndView userLogin(@RequestParam("inputEmail") String email,
			@RequestParam("inputPassword") String password, HttpSession session)
			throws JsonGenerationException, JsonMappingException, IOException {

		ModelAndView mv = new ModelAndView();

		User user = new User();
		user.setEmail(email);
		user.setPassword(password);

		// Selektierung des Nachnamens
		String name = userDao.loginUser(user);
		// Setzen der A_ID
		int a_id = userDao.isApplicant(email);
		// Überprüfung des UserTyps(Applicant oder Recruiter
		boolean isApplicant;
		if (a_id > 0) {
			isApplicant = true;

			// Laden der Skills aus der Datenbank in lokales File
			Skills skills = skillsDao.oldSkills(a_id);
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(new File(System.getProperty("user.dir") + "/skills.json"), skills);
		} else {
			isApplicant = false;
		}

		// session Variable setzen
		session.setAttribute("userEmail", email);
		session.setAttribute("isApplicant", isApplicant);
		session.setAttribute("a_id", a_id);

		if (name != null) {
			mv.addObject("msg", "Willkommen " + name + ", Sie haben sich erfolgreich eingeloggt.");
			mv.setViewName("overviewUser");
		} else {
			mv.addObject("msg", "Invalid user id or password.");
			mv.setViewName("login");
		}
		return mv;
	}
}
