package de.hfu.bewerbermanagement.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import de.hfu.bewerbermanagement.model.Bewerber;
import de.hfu.bewerbermanagement.model.User;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao{
	
	private JdbcTemplate jdbcTemplate;
	
	public UserDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
//	public int registerUser(User user) {
//		// TODO Auto-generated method stub
//		String sql = "INSERT INTO user_data (user_id,user_pass,userName,userSurname,email) VALUES(?,?,?,?,?)";
//		
//		try {
//			int counter = jdbcTemplate.update(sql, new Object[] {user.getUserId(), user.getPassword(), user.getUserName(), user.getUserSurname(), user.getEmail()});
//			return counter;
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		return 0;
//	}

	public int registerBewerber(Bewerber bewerber) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO bewerber_data (user_id,user_pass,userName,userSurname,email,userEntrydate,userSubject,userSpecialization,userSallery) VALUES(?,?,?,?,?,?,?,?)";
		
		try {
			int counter = jdbcTemplate.update(sql, new Object[] {bewerber.getUserId(), bewerber.getPassword(), bewerber.getUserName(), bewerber.getUserSurname(), bewerber.getEmail(),bewerber.getEntryDate(),bewerber.getSubject(),bewerber.getSpecialization(),bewerber.getSallery()});
			return counter;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public String loginUser(User user) {
		// TODO Auto-generated method stub

		//String sql = "SELECT user_id FROM user_data WHERE user_id=? AND user_pass=?";
		String sql = "SELECT user_id FROM user_data WHERE email=? AND user_pass=?";
		
		try {

			String userId = jdbcTemplate.queryForObject(sql, new Object[] {
					user.getUserId(), user.getPassword() }, String.class);

			//Session Variable UserId setzen
			//session.setAttribute("userId", userId);

			return userId;
			
		} catch (Exception e) {
			return null;
		}
	}
//@ToDo
	public Bewerber showProfil() {
		// TODO Auto-generated method stub
		//String id = (String) session.getAttribute("userId");
		return null;
	}

	@Override
	public Bewerber changeProfil() {
		// TODO Auto-generated method stub
		return null;
	}

}


