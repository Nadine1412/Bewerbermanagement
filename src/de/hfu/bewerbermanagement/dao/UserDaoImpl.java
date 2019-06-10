package de.hfu.bewerbermanagement.dao;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import de.hfu.bewerbermanagement.model.Bewerber;
import de.hfu.bewerbermanagement.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserDaoImpl implements UserDao{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private JsonNode jsonNode;
	
	
	public UserDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}


	public int registerBewerber(Bewerber bewerber) {
		// SQL Statement aus json lesen (Nadine Jakob 07.06.2019)
		String key = "registerBewerber";
		String statement = jsonNode.get(key).asText();

		//String sql = "INSERT INTO bewerber_data (user_pass,userName,userSurname,email,userEntrydate,userSubject,userSpecialization,userSallery) VALUES(?,?,?,?,?,?,?,?)";
		if(statement != null) {
			try {
				int counter = jdbcTemplate.update(statement, new Object[] { bewerber.getPassword(), bewerber.getUserName(), bewerber.getUserSurname(), bewerber.getEmail(),bewerber.getEntryDate(),bewerber.getSubject(),bewerber.getSpecialization(),bewerber.getSallery()});

				return counter;
			} catch(Exception e) {
				e.printStackTrace();
			}
			return 0;
		} else {
			return 0;
		}
		
	}
	
	@Override
	public String loginUser(User user) {
		
		// SQL Statement aus json lesen (Nadine Jakob 07.06.2019)
		String key = "login";
		String statement = jsonNode.get(key).asText();
		
		if(statement  != null) {
			try {
				String resultName = jdbcTemplate.queryForObject(statement, new Object[] {user.getEmail(), user.getPassword()}, String.class);
				return resultName;
			} catch (Exception e) {
				return null;
				//@ToDo error Message ausgeben
			}
		} else {
			return null;
			//@ToDo error Message ausgeben
		}
	}


	public Bewerber showProfil(HttpSession session) {
		// get SQL Statement (Nadine Jakob 10.06.2019)
		String key = "showProfile";
		String statement = jsonNode.get(key).asText();
		
		if(statement != null) {
			try {
				String email = session.getAttribute("userEmail").toString(); //kommt in Präsentationslogik
				
				Bewerber result = jdbcTemplate.queryForObject(statement, new Object[] {email}, new RowMapper<Bewerber>() {
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
		} else {
			return null;
		}
	}

	@Override
	public int changeProfil(Bewerber bewerber) {
		String userId = bewerber.getUserId();
		
		// get SQL Statement (Nadine Jakob 10.06.2019)
		String key = "changeProfile";
		String statement = jsonNode.get(key).asText();

		if(statement != null) {
			try {
				int counter = jdbcTemplate.update(statement, new Object[] {bewerber.getUserName(), bewerber.getUserSurname(), bewerber.getEmail(), bewerber.getEntryDate(), 
						bewerber.getSubject(), bewerber.getSpecialization(), bewerber.getSallery(), bewerber.getPassword(), bewerber.getUserId()});
				
				return counter;
				}
				catch (Exception e) {
					return 0;
				}
		} else {
			return 0;
		}
	}

}


