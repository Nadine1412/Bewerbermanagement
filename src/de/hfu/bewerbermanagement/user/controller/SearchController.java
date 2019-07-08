package de.hfu.bewerbermanagement.user.controller;

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

import de.hfu.bewerbermanagement.business.ApplicantManager;
import de.hfu.bewerbermanagement.business.RecruiterManager;
import de.hfu.bewerbermanagement.skills.model.Skills;
import de.hfu.bewerbermanagement.user.dao.UserDao;
import de.hfu.bewerbermanagement.user.model.Applicant;
import de.hfu.bewerbermanagement.user.model.Recruiter;

@Controller
public class SearchController {
	
	@Autowired
	private UserDao userDao;
	
	// Weiterleiten der ausgewählten Fähigkeiten aus der JSP
	@RequestMapping(value = "/searchApplicant", method = RequestMethod.POST)
	public ModelAndView processRequest(HttpServletRequest request, HttpSession session)
		throws ServletException, IOException{
			
		// Auslesen der Checkboxen aus der searchApplicant.jsp
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

			// Anlegen des ModelAndView Objektes
			ModelAndView mv = new ModelAndView();
			
			//Erzeugen der Liste für die Ausgabe der Skills
			List<String> searchedSkills = new ArrayList<String>();
			
			//Schreiben der gecheckten Skills in die searchedSkills Liste
			if(java != null) {
				searchedSkills.add(java);
			}
			if(javaScript != null) {
				searchedSkills.add(javaScript);
			}
			if(cPlusPlus != null) {
				searchedSkills.add(cPlusPlus);
			}
			if(python != null) {
				searchedSkills.add(python);
			}
			if(html != null) {
				searchedSkills.add(html);
			}
			
			if(word != null) {
				searchedSkills.add(word);
			}
			if(excel != null) {
				searchedSkills.add(excel);
			}
			if(powerpoint != null) {
				searchedSkills.add(powerpoint);
			}
			if(git != null) {
				searchedSkills.add(git);
			}
			if(jira != null) {
				searchedSkills.add(jira);
			}
			
			if(german != null) {
				searchedSkills.add(german);
			}
			if(english != null) {
				searchedSkills.add(english);
			}
			if(spanish != null) {
				searchedSkills.add(spanish);
			}
			if(french != null) {
				searchedSkills.add(french);
			}
			if(chinese != null) {
				searchedSkills.add(chinese);
			}
						
			//Weiterleiten der Liste an userDao und Liste mit zutreffenden Applicants von userDao erhalten
			List<Applicant> list = userDao.searchApplicantswithSkills(searchedSkills);
			
			//Check ob Applicants mit gewünschten Skills vorhanden
			if(list.size()!= 0) {
				mv.addObject("applicants", list);
				mv.setViewName("searchApplicants");
			} else {
				mv.addObject("msg", "No applicant with selected skills found.");
				mv.setViewName("searchApplicants");
			}
			return mv;
	}		
}
