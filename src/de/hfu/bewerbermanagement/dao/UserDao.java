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
	
	
	// Profil anzeigen
	public Applicant showProfil(HttpSession session);

	
	// Profil ändern
	public int changeProfil(Applicant applicant);

}
