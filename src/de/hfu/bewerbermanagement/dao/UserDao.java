package de.hfu.bewerbermanagement.dao;

import javax.servlet.http.HttpSession;

import de.hfu.bewerbermanagement.model.Applicant;
import de.hfu.bewerbermanagement.model.Recruiter;
import de.hfu.bewerbermanagement.model.User;
public interface UserDao {
	
	//public String readSQLStatement(String key);
	
	public int registerApplicant(Applicant applicant);
	public int registerRecruiter(Recruiter recruiter);

	public String loginUser(User user);
	
	
	//Profil anzeigen
	public Applicant showApplicantProfile(HttpSession session);
	public Recruiter showRecruiterProfile(HttpSession session);

	
	// Profil ändern
	public int changeProfil(Applicant applicant);
	
	// Prüfen ob Bewerber oder Personaler
	public Boolean isApplicant(String email);

}
