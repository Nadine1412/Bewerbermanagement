package de.hfu.bewerbermanagement.dao;

import javax.servlet.http.HttpSession;

import de.hfu.bewerbermanagement.model.Bewerber;
import de.hfu.bewerbermanagement.model.Personaler;
import de.hfu.bewerbermanagement.model.User;
public interface UserDao {
	
	public int registerBewerber(Bewerber bewerber);

	public String loginUser(User user);
	
	// Profil anzeigen
	public Bewerber showProfil(HttpSession session);

	
	// Profil ändern
	public int changeProfil(Bewerber bewerber);

}
