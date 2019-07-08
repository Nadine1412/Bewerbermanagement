package de.hfu.bewerbermanagement.business;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import de.hfu.bewerbermanagement.user.model.Applicant;
import de.hfu.bewerbermanagement.user.model.Recruiter;

//Fachlogik vom Bewerber
//exception handling
//sql statement von fachlogik trennen
public class RecruiterManager {
	
	// Exceptionhandling für den Personaler
	public Map<String, Boolean> expressionRecruiter(Recruiter recruiter) {
		
		Map<String, Boolean> myMap = new HashMap<String, Boolean>();
		
		//Regular Expressions
		boolean resultName = Pattern.matches("^[A-Z][a-z]+$", recruiter.getUserName()); //Keine Zahlen im Namen
		boolean resultSurname = Pattern.matches("^[A-Z][a-z]+$", recruiter.getUserSurname()); //Keine Zahlen im Nachnamen
		boolean resultPosition = Pattern.matches("^[A-Z][A-Z0-9a-z.\\/_%+-]+", recruiter.getPosition()); // Großer Anfangsbuchstabe
		boolean resultEmail = Pattern.matches("[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,64}", recruiter.getEmail()); //Überprüfen der Email-Adresse
		boolean resultPassword = Pattern.matches("(?=.*?[A-Za-z]).{4,}", recruiter.getPassword());	
		boolean resultBirthday;
		if(recruiter.getBirthday() == "") {
			resultBirthday = false;
		} else {
			resultBirthday = true;
		}
		boolean resultEnterprise;
		if(recruiter.getEnterprise() == "") {
			resultEnterprise = false;
		} else {
			resultEnterprise = true;
		}
		
		// Speichern der Ergebnisse in einer Map
		myMap.put("name", resultName);
		myMap.put("surname", resultSurname);
		myMap.put("birthday", resultBirthday);
		myMap.put("enterprise", resultEnterprise);
		myMap.put("position", resultPosition);
		myMap.put("email", resultEmail);
		myMap.put("password", resultPassword);
		
		return myMap;		
	}


}
