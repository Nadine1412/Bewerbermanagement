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

@Controller
public class SkillsController {
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value = "/userSkills", method = RequestMethod.POST)
	public ModelAndView processRequest(HttpServletRequest request, HttpSession session)
		throws ServletException, IOException{
			
			String selectProgramming[]=request.getParameterValues("chkProgramming");
			String selectOffice[]=request.getParameterValues("chkOffice");
			String selectLangugage[]=request.getParameterValues("chkLanguage");

			String programming = Arrays.toString(selectProgramming);
			programming = programming.substring(1, programming.length()-1);
			
			String office = Arrays.toString(selectOffice);
			office = office.substring(1, office.length()-1);
			
			String language = Arrays.toString(selectLangugage);
			language = language.substring(1, language.length()-1);


			ModelAndView mv = new ModelAndView();
			
			//Erzeugen der Map f¸r die Ausgabe der Substrings
			Map<String, String> map = new HashMap<String, String>();
			
			map.put("programmingLanguage", programming);
			map.put("office", office);
			map.put("language", language);
			
			//session Variable setzen
			int a_id = (int) session.getAttribute("a_id");
			
			int counter = userDao.addSkills(map, a_id);
					
			if (counter > 0) {
			mv.addObject("msg", "Skills successfully added.");
			mv.addObject("programming", programming);
			mv.addObject("language", language);
			mv.addObject("office", office);


			mv.setViewName("userSkills");
			} else {
				mv.addObject("msg", "Error - check the console log");
				mv.setViewName("userSkills");
			}
			
			return mv;	
	}
	
//	@RequestMapping(value = "/userSkills", method = RequestMethod.POST)
//	public ModelAndView recruiterRegistration(
//			@RequestParam("selectJava") String java, @RequestParam("selectJavaScript") String javaScript, 
//			@RequestParam("selectC++") String cpp, @RequestParam("selectPython") String python, 
//			@RequestParam("selectHTML") String html,  
//			
//			@RequestParam("selectWord") String word, @RequestParam("selectExcel") String excel,
//			@RequestParam("selectPowerpoint") String powerpoint, @RequestParam("selectGit") String gitHub,
//			@RequestParam("selectJira") String jira,
//			
//			@RequestParam("selectDeutsch") String deutsch, @RequestParam("selectEnglisch") String englisch,
//			@RequestParam("selectSpanisch") String spanisch, @RequestParam("selectFranzoesisch") String franzoesisch,
//			@RequestParam("selectChinesisch") String chinesisch) {
//		
//		ModelAndView mv = new ModelAndView();
//
//				//Aufruf der Methode ExpressionApplicant
//				Map<String, String> map = new HashMap<String, String>();
//				
//				map.put("programmingLanguage", java + "," + javaScript + "," + cpp + "," + python + "," + html);
//				map.put("office", word + "," + excel + "," + powerpoint + "," + gitHub + "," + jira);
//				map.put("language", deutsch + "," + englisch + "," + spanisch + "," + franzoesisch + "," + chinesisch);
//				
//				System.out.println("programmingLanguage: "+ java + "," + javaScript + "," + cpp + "," + python + "," + html);
//				System.out.println("office: "+ word + "," + excel + "," + powerpoint + "," + gitHub + "," + jira);
//				System.out.println("language: "+ deutsch + "," + englisch + "," + spanisch + "," + franzoesisch + "," + chinesisch);
////				if(map.get("name") && map.get("surname") && map.get("birthday") && map.get("enterprise") && map.get("position") && map.get("email") && map.get("password"))
////				{
////					System.out.println("Richtige Eingabe." + " Name: " + map.get("name") + " Nachname: " + map.get("surname") + " Geburtstag: " + map.get("birthday") + " Unternehmen: " + map.get("enterprise") + " Position: " + map.get("position") + " EMail: " + map.get("email") + " Passwort: " + map.get("password"));
////					int counter = userDao.registerRecruiter(recruiter);
////		
////						if (counter > 0) {
////							mv.addObject("msg", "User registration successful.");
////							mv.setViewName("login");
////						} else {
////							mv.addObject("msg", "Error - check the console log");
////							mv.setViewName("registrationRecruiter");
////						}
////				} else {
////					System.out.println("Falsche Eingabe." + " Name: " + map.get("name") + " Nachname: " + map.get("surname") + " Geburtstag: " + map.get("birthday") + " Unternehmen: " + map.get("enterprise") + " Position: " + map.get("position") + " EMail: " + map.get("email") + " Passwort: " + map.get("password"));
////
////					if(!map.get("name")) {
////						mv.addObject("errorName", "Falsche Eingabe. Bitte mit einem Groﬂbuchstaben beginnen.");
////					}
////					if(!map.get("surname")) {
////						mv.addObject("errorSurname", "Falsche Eingabe. Bitte mit einem Groﬂbuchstaben beginnen.");
////					}
////					if(!map.get("birthday")) {
////						mv.addObject("errorBirthday", "Bitte geben Sie ein Datum ein.");
////					}
////					if(!map.get("enterprise")) {
////						mv.addObject("errorEnterprise", "Falsche Eingabe. Bitte ein Unternehmen eintragen.");
////					}
////					if(!map.get("position")) {
////						mv.addObject("errorPosition", "Falsche Eingabe. Bitte mit einem Groﬂbuchstaben beginnen.");
////					}
////					if(!map.get("email")) {
////						mv.addObject("errorEmail", "Bitte eine richtige E-Mailadresse eingeben.");
////					}
////					if(!map.get("password")) {
////						mv.addObject("errorPassword", "Das Passwort muss mind. 4 Zeichen enthalten.");
////					}
////					
////					mv.addObject("recruiter",recruiter);
////					mv.setViewName("registrationRecruiter");
////							
////				}
//				
//				return mv;
//	}
	
	
	
	
	
}
