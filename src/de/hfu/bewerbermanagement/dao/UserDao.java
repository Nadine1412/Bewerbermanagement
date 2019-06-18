package de.hfu.bewerbermanagement.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import de.hfu.bewerbermanagement.model.Applicant;
import de.hfu.bewerbermanagement.model.Recruiter;
import de.hfu.bewerbermanagement.model.Skills;
import de.hfu.bewerbermanagement.model.User;
public interface UserDao {
	
	//public String readSQLStatement(String key);
	
	public int registerApplicant(Applicant applicant);
	public int registerRecruiter(Recruiter recruiter);

	public String loginUser(User user);
	
	// Profil anzeigen
	public Applicant showApplicantProfile(HttpSession session);
	public Recruiter showRecruiterProfile(HttpSession session);

	
	// Profil ändern
	public int changeApplicantProfile(Applicant applicant);
	public int changeRecruiterProfile(Recruiter recruiter);
	
	// Prüfen ob Bewerber oder Personaler
	public int isApplicant(String email);
	
	// Skills hinzufügen
	public int addSkills(Skills skills, int a_id);
	
	// Prüfen ob bereits Skills eingegeben wurden
	boolean isSkillAvailable(int a_id);

	// Bereits eingetragene Skills anzeigen
	public Skills oldSkills(int a_id);
}
