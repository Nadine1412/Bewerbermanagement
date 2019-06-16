package de.hfu.bewerbermanagement.dao;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import de.hfu.bewerbermanagement.model.Applicant;
import de.hfu.bewerbermanagement.model.Recruiter;
import de.hfu.bewerbermanagement.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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


	public int registerApplicant(Applicant applicant) {
		// SQL Statement aus json lesen (Nadine Jakob 07.06.2019)
		String keyUser = "registerUser";
		String keyApplicant = "registerApplicant";
		String statementUser = jsonNode.get(keyUser).asText();
		String statementApplicant = jsonNode.get(keyApplicant).asText();

		//"registerUser": "INSERT INTO user (password,name,surname,email,birthday VALUES(?,?,?,?,?)"
		if(statementUser != null) {
			try {
				int counterUser = jdbcTemplate.update(statementUser, new Object[] { applicant.getPassword(), applicant.getUserName(), applicant.getUserSurname(), applicant.getEmail(),applicant.getBirthday()});
				//"registerApplicant": "INSERT INTO applicant (entrydate,subject,specialization,sallery,u_id) VALUES(?,?,?,?,(SELECT u_id FROM user WHERE email=?)"
				if(statementApplicant != null && counterUser != 0) {
					int counterApplicant = jdbcTemplate.update(statementApplicant, new Object[] {applicant.getEntryDate(), applicant.getSubject(), applicant.getSpecialization(), applicant.getSallery(), applicant.getEmail()});
					return counterApplicant;
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			return 0;
		} else {
			return 0;
		}	
	}
	
	@Override
	public int registerRecruiter(Recruiter recruiter) {
		// SQL Statement aus json lesen (Nadine Jakob 07.06.2019)
				String keyUser = "registerUser";
				String keyRecruiter = "registerRecruiter";
				String statementUser = jsonNode.get(keyUser).asText();
				String statementRecruiter = jsonNode.get(keyRecruiter).asText();

				//"registerUser": "INSERT INTO user (password,name,surname,email,birthday VALUES(?,?,?,?,?)"
				if(statementUser != null) {
					try {
						int counterUser = jdbcTemplate.update(statementUser, new Object[] { recruiter.getPassword(), recruiter.getUserName(), recruiter.getUserSurname(), recruiter.getEmail(),recruiter.getBirthday()});
						//"registerRecruiter": "INSERT INTO recruiter (position,enterprise, u_id) VALUES(?,?,(SELECT u_id FROM user WHERE email=?))",
						if(statementRecruiter != null && counterUser != 0) {
							int counterRecruiter = jdbcTemplate.update(statementRecruiter, new Object[] {recruiter.getPosition(), recruiter.getEnterprise(), recruiter.getEmail()});
							return counterRecruiter;
						}
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
	
	//Prüfen ob Applicant oder Recruiter
	@Override
	public Boolean isApplicant(String email) {
		String key = "isApplicant";
		String statement = jsonNode.get(key).asText();
		
		if(statement  != null) {
			try {
				int resultAid = jdbcTemplate.queryForObject(statement, new Object[] {email}, int.class);
				// Ist ein Applicant
					return true;
//				}
				
			} catch (EmptyResultDataAccessException e) {
				// Ist ein Recruiter
				return false;
			} catch (Exception e) {
				return null;
			}
		} else {
			return null;
		}
	}


	// Applicant Profil anzeigen
	@Override
	public Applicant showApplicantProfile(HttpSession session) {
		// get SQL Statement (Nadine Jakob 10.06.2019)
		String key = "showApplicantProfile";
		String statement = jsonNode.get(key).asText();
		
		if(statement != null) {
			try {
				String email = session.getAttribute("userEmail").toString(); //kommt in Präsentationslogik
				
				Applicant result = jdbcTemplate.queryForObject(statement, new Object[] {email}, new RowMapper<Applicant>() {
					@Override
					public Applicant mapRow(ResultSet rs, int rowNum) throws SQLException {
						Applicant applicant = new Applicant();
						applicant.setEmail(rs.getString("email"));
						applicant.setEntryDate(rs.getDate("entrydate").toString());
						applicant.setSallery(rs.getString("sallery"));
						applicant.setPassword(rs.getString("password"));
						applicant.setBirthday(rs.getString("birthday"));
						applicant.setSpecialization(rs.getString("specialization"));
						applicant.setSubject(rs.getString("subject"));
						applicant.setUserId(rs.getString("u_id"));
						applicant.setUserName(rs.getString("name"));
						applicant.setUserSurname(rs.getString("surname"));
						return applicant;
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

	// Recruiter Profil anzeigen
	@Override
		public Recruiter showRecruiterProfile(HttpSession session) {
			// get SQL Statement (Nadine Jakob 10.06.2019)
			String key = "showRecruiterProfile";
			String statement = jsonNode.get(key).asText();
			
			if(statement != null) {
				try {
					String email = session.getAttribute("userEmail").toString(); //kommt in Präsentationslogik
					
					Recruiter result = jdbcTemplate.queryForObject(statement, new Object[] {email}, new RowMapper<Recruiter>() {
						@Override
						public Recruiter mapRow(ResultSet rs, int rowNum) throws SQLException {
							Recruiter recruiter = new Recruiter();
							recruiter.setEmail(rs.getString("email"));
							recruiter.setPassword(rs.getString("password"));
							recruiter.setBirthday(rs.getString("birthday"));
							recruiter.setPosition(rs.getString("position"));
							recruiter.setEnterprise(rs.getString("enterprise"));
							recruiter.setUserId(rs.getString("u_id"));
							recruiter.setUserName(rs.getString("name"));
							recruiter.setUserSurname(rs.getString("surname"));
							return recruiter;
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
	
	// Applicant Profil ändern
	@Override
	public int changeApplicantProfile(Applicant applicant) {
		String userId = applicant.getUserId();
		
		// get SQL Statement (Nadine Jakob 10.06.2019)
		String key = "changeApplicantProfile";
		String statement = jsonNode.get(key).asText();

		if(statement != null) {
			try {
				int counter = jdbcTemplate.update(statement, new Object[] {applicant.getUserName(), applicant.getUserSurname(), applicant.getEmail(), applicant.getBirthday(), applicant.getEntryDate(), 
						applicant.getSubject(), applicant.getSpecialization(), applicant.getSallery(), applicant.getPassword(), applicant.getUserId()});
				
				return counter;
				}
				catch (Exception e) {
					return 0;
				}
		} else {
			return 0;
		}
	}


	// Recruiter Profil ändern
	@Override
	public int changeRecruiterProfile(Recruiter recruiter) {
		
		String key = "changeRecruiterProfile";
		String statement = jsonNode.get(key).asText();

		if(statement != null) {
			try {
				int counter = jdbcTemplate.update(statement, new Object[] {recruiter.getUserName(), recruiter.getUserSurname(), recruiter.getEmail(), recruiter.getBirthday(), recruiter.getEnterprise(), 
						recruiter.getPosition(), recruiter.getPassword(), recruiter.getUserId()});
				
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

