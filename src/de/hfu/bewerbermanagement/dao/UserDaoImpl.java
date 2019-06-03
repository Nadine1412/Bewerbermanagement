package de.hfu.bewerbermanagement.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import de.hfu.bewerbermanagement.model.Bewerber;
import de.hfu.bewerbermanagement.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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
//		String sql = "INSERT INTO bewerber_data (user_id,user_pass,userName,userSurname,email,userEntrydate,userSubject,userSpecialization,userSallery) VALUES(?,?,?,?,?,?,?,?)";
		String sql = "INSERT INTO bewerber_data (user_pass,userName,userSurname,email,userEntrydate,userSubject,userSpecialization,userSallery) VALUES(?,?,?,?,?,?,?,?)";

		try {
//			int counter = jdbcTemplate.update(sql, new Object[] {bewerber.getUserId(), bewerber.getPassword(), bewerber.getUserName(), bewerber.getUserSurname(), bewerber.getEmail(),bewerber.getEntryDate(),bewerber.getSubject(),bewerber.getSpecialization(),bewerber.getSallery()});
			int counter = jdbcTemplate.update(sql, new Object[] { bewerber.getPassword(), bewerber.getUserName(), bewerber.getUserSurname(), bewerber.getEmail(),bewerber.getEntryDate(),bewerber.getSubject(),bewerber.getSpecialization(),bewerber.getSallery()});

			return counter;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public int loginUser(User user) {
		// TODO Auto-generated method stub

		String sql = "SELECT user_id FROM user_data WHERE user_id=? AND user_pass=?";
		//String sql = "SELECT user_id FROM user_data WHERE email='" + user.getEmail() +"' AND user_pass='"+ user.getPassword()+"'";
			
		try {
	
		//	int userId = jdbcTemplate.query(sql,new Object[] {
			//		user.getEmail(), user.getPassword() }, Integer.class);
			
			//int userId = jdbcTemplate.query(sql,(ResultSet rs,int rowNum),new User(rs.ge))
			int result = jdbcTemplate.queryForObject(
				    "SELECT COUNT(*) FROM user_data", Integer.class);
			System.out.println(result);
			//Session Variable UserId setzen
			//session.setAttribute("userId", userId);
			
			return result;
			
		} catch (Exception e) {
			return 0;
		}
	}


	public Bewerber showProfil(HttpSession session) {
		String sql = "SELECT * FROM bewerber_data WHERE email=?";			
		try {
			String email = session.getAttribute("userEmail").toString();
			
			Bewerber result = jdbcTemplate.queryForObject(sql, new Object[] {email}, new RowMapper<Bewerber>() {
				@Override
				public Bewerber mapRow(ResultSet rs, int rowNum) throws SQLException {
					Bewerber bewerber = new Bewerber();
					bewerber.setEmail(rs.getString("email"));
					bewerber.setEntryDate(rs.getDate("userEntrydate").toString());
					bewerber.setSallery(rs.getString("userSallery"));
					bewerber.setPassword(rs.getString("user_pass"));
					bewerber.setSpecialization(rs.getString("userSpecialization"));
					bewerber.setSubject(rs.getString("userSubject"));
					bewerber.setUserId(rs.getString("user_id"));
					bewerber.setUserName(rs.getString("userName"));
					bewerber.setUserSurname(rs.getString("userSurname"));
					return bewerber;
				}
			} );	
			return result;		
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int changeProfil(Bewerber bewerber) {
		// TODO Auto-generated method stub
		String userId = bewerber.getUserId();
		
		try {
		String updateSql = "UPDATE bewerber_data SET userName=?, userSurname=?, email=?, userEntrydate=?, userSubject=?, userSpecialization=?, userSallery=?, user_pass=? WHERE user_id=?";

		int counter = jdbcTemplate.update(updateSql, new Object[] {bewerber.getUserName(), bewerber.getUserSurname(), bewerber.getEmail(), bewerber.getEntryDate(), bewerber.getSubject(), bewerber.getSpecialization(), bewerber.getSallery(), bewerber.getPassword(), bewerber.getUserId()});
		
		return counter;
		}
		catch (Exception e) {
			return 0;
		}
	}

}


