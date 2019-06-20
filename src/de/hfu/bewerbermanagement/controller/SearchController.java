package de.hfu.bewerbermanagement.controller;

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
import de.hfu.bewerbermanagement.dao.UserDao;
import de.hfu.bewerbermanagement.model.Applicant;
import de.hfu.bewerbermanagement.model.Recruiter;
import de.hfu.bewerbermanagement.model.Skills;

@Controller
public class SearchController {
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value = "/searchApplicant", method = RequestMethod.POST)
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
			List<String> allSkills = new ArrayList<String>();
			
			
			if(java != null) {
				allSkills.add(java);
			}
			if(javaScript != null) {
				allSkills.add(javaScript);
			}
			if(cPlusPlus != null) {
				allSkills.add(cPlusPlus);
			}
			if(python != null) {
				allSkills.add(python);
			}
			if(html != null) {
				allSkills.add(html);
			}
			
			if(word != null) {
				allSkills.add(word);
			}
			if(excel != null) {
				allSkills.add(excel);
			}
			if(powerpoint != null) {
				allSkills.add(powerpoint);
			}
			if(git != null) {
				allSkills.add(git);
			}
			if(jira != null) {
				allSkills.add(jira);
			}
			
			if(german != null) {
				allSkills.add(german);
			}
			if(english != null) {
				allSkills.add(english);
			}
			if(spanish != null) {
				allSkills.add(spanish);
			}
			if(french != null) {
				allSkills.add(french);
			}
			if(chinese != null) {
				allSkills.add(chinese);
			}
						
			
			List<Applicant> list = userDao.searchApp(allSkills);
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
