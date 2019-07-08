package de.hfu.bewerbermanagement.skills.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.hfu.bewerbermanagement.business.ApplicantManager;
import de.hfu.bewerbermanagement.business.RecruiterManager;
import de.hfu.bewerbermanagement.file.dao.FileDao;
import de.hfu.bewerbermanagement.skills.dao.SkillsDao;
import de.hfu.bewerbermanagement.skills.model.Skills;
import de.hfu.bewerbermanagement.user.dao.UserDao;
import de.hfu.bewerbermanagement.user.model.Applicant;
import de.hfu.bewerbermanagement.user.model.Recruiter;

@Controller
public class SkillsController {
	
	@Autowired
	private SkillsDao skillsDao;
	
	@RequestMapping(value = "/userSkills", method = RequestMethod.POST)
	public ModelAndView processRequest(HttpServletRequest request, HttpSession session)
		throws ServletException, IOException{
			
			String java = request.getParameter("chkJava");
			String javaScript =request.getParameter("chkJavaScript");
			String cPlusPlus =request.getParameter("chkC++");
			String python =request.getParameter("chkPython");
			String html =request.getParameter("chkHtml");

			String word = request.getParameter("chkWord");
			String excel =request.getParameter("chkExcel");
			String powerpoint =request.getParameter("chkPowerpoint");
			String git =request.getParameter("chkGit");
			String jira =request.getParameter("chkJira");
			
			String german = request.getParameter("chkGerman");
			String english =request.getParameter("chkEnglish");
			String spanish =request.getParameter("chkSpanish");
			String french =request.getParameter("chkFrench");
			String chinese =request.getParameter("chkChinese");


			ModelAndView mv = new ModelAndView();
			
			//Erzeugen der Liste für die Ausgabe der Skills
			List<String> programmingLanguage = new ArrayList<String>();
			List<String> office = new ArrayList<>();
			List<String> language = new ArrayList<>();
			
			// in die ProgrammingLanguage-Liste speichern
			if(java != null) {
				programmingLanguage.add(java);
			}
			if(javaScript != null) {
				programmingLanguage.add(javaScript);
			}
			if(cPlusPlus != null) {
				programmingLanguage.add(cPlusPlus);
			}
			if(python != null) {
				programmingLanguage.add(python);
			}
			if(html != null) {
				programmingLanguage.add(html);
			}
			
			// in die Office-Liste speichern
			if(word != null) {
				office.add(word);
			}
			if(excel != null) {
				office.add(excel);
			}
			if(powerpoint != null) {
				office.add(powerpoint);
			}
			if(git != null) {
				office.add(git);
			}
			if(jira != null) {
				office.add(jira);
			}
			
			// in die Language-Liste speichern
			if(german != null) {
				language.add(german);
			}
			if(english != null) {
				language.add(english);
			}
			if(spanish != null) {
				language.add(spanish);
			}
			if(french != null) {
				language.add(french);
			}
			if(chinese != null) {
				language.add(chinese);
			}
			
			//session Variable setzen
			int a_id = (int) session.getAttribute("a_id");
			
			Skills skills = new Skills();
			skills.setProgrammingLanguage(programmingLanguage);
			skills.setOffice(office);
			skills.setLanguage(language);
			
			// Updaten der Skills im lokalen File
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(new File(System.getProperty("user.dir") + "/skills.json"), skills);
			
			// Updaten der Skills in der Datenbank
			int counter = skillsDao.addSkills(skills, a_id);
						
			if (counter > 0) {
				String programmingStr = programmingLanguage.toString();
				String officeStr = office.toString();
				String languageStr = language.toString();
				
				String subProgramming = programmingStr.substring(1, programmingStr.length()-1);
				String subOffice = officeStr.substring(1, officeStr.length()-1);
				String subLanguage = languageStr.substring(1, languageStr.length()-1);
						
			mv.addObject("msg", "Fäigkeiten erfolgreich hinzugefügt.");
			mv.addObject("programmingLanguage", subProgramming);
			mv.addObject("office", subOffice);
			mv.addObject("language", subLanguage);

			mv.setViewName("userSkills");
			} else {
				mv.addObject("msg", "Error - check the console log");
				mv.setViewName("userSkills");
			}
			
			return mv;	
	}
	

}
