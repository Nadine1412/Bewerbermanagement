package de.hfu.bewerbermanagement.business;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import de.hfu.bewerbermanagement.user.controller.UserRegistrationController;
import de.hfu.bewerbermanagement.user.model.Applicant;

//Fachlogik vom Bewerber
//exception handling
//sql statement von fachlogik trennen

public class ApplicantManager {
	
	// Exceptionhandling für den Bewerber
		public Map<String, Boolean> expressionApplicant(Applicant applicant) {
			
			Map<String, Boolean> myMap = new HashMap<String, Boolean>();
			
			//Regular Expressions
			boolean resultName = Pattern.matches("^[A-Z][a-z]+$", applicant.getUserName()); //Keine Zahlen im Namen
			boolean resultSurname = Pattern.matches("^[A-Z][a-z]+$", applicant.getUserSurname()); //Keine Zahlen im Nachnamen	
			boolean resultSubject = Pattern.matches("^[A-Z][A-Z0-9a-z.\\/_%+-]+", applicant.getSubject()); // Großer Anfangsbuchstabe
			boolean resultSpecialization = Pattern.matches("^[A-Z][A-Z0-9a-z.\\/_%+-]+", applicant.getSpecialization()); // Großer Anfangsbuchstabe
			boolean resultSalary = Pattern.matches("^[1-9][0-9]{2,}$", applicant.getSalary()); // Keine 0 am Anfang und nur Positiveganzzahlen (mind.3stellig)
			boolean resultEmail = Pattern.matches("[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,64}", applicant.getEmail()); // Überprüfen der EMail
			boolean resultPassword = Pattern.matches("(?=.*?[A-Za-z]).{4,}", applicant.getPassword());
			
			boolean resultBirthday;
			if(applicant.getBirthday() == "") {
				resultBirthday = false;
			} else {
				resultBirthday = true;
			}
			boolean resultEntrydate;
			if(applicant.getEntryDate() == "") {
				resultEntrydate = false;
			} else {
				resultEntrydate = true;
			}
			
			myMap.put("name", resultName);
			myMap.put("surname", resultSurname);
			myMap.put("birthday", resultBirthday);
			myMap.put("entrydate", resultEntrydate);
			myMap.put("subject", resultSubject);
			myMap.put("specialization", resultSpecialization);
			myMap.put("salary", resultSalary);
			myMap.put("email", resultEmail);
			myMap.put("password", resultPassword);
			
			return myMap;		
		}

	
}
