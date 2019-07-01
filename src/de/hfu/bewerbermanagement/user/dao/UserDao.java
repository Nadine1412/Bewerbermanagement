package de.hfu.bewerbermanagement.user.dao;

import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import de.hfu.bewerbermanagement.skills.model.Skills;
import de.hfu.bewerbermanagement.user.model.Applicant;
import de.hfu.bewerbermanagement.user.model.Recruiter;
import de.hfu.bewerbermanagement.user.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class UserDao{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private JsonNode jsonNode;
	
	
	public UserDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// Applicant registrieren
	public int registerApplicant(Applicant applicant) {
		// SQL Statement aus json lesen (Nadine Jakob 07.06.2019)
		String keyUser = "user.register";
		String keyApplicant = "applicant.register";
		String statementUser = jsonNode.get(keyUser).asText();
		String statementApplicant = jsonNode.get(keyApplicant).asText();

		if(statementUser != null) {
			try {
				int counterUser = jdbcTemplate.update(statementUser, new Object[] { applicant.getPassword(), applicant.getUserName(), applicant.getUserSurname(), applicant.getEmail(),applicant.getBirthday()});
				if(statementApplicant != null && counterUser != 0) {
					int counterApplicant = jdbcTemplate.update(statementApplicant, new Object[] {applicant.getEntryDate(), applicant.getSubject(), applicant.getSpecialization(), applicant.getSalary(), applicant.getEmail()});
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
	
	//Recruiter registrieren
	public int registerRecruiter(Recruiter recruiter) {
				String keyUser = "user.register";
				String keyRecruiter = "recruiter.register";
				String statementUser = jsonNode.get(keyUser).asText();
				String statementRecruiter = jsonNode.get(keyRecruiter).asText();

				if(statementUser != null) {
					try {
						int counterUser = jdbcTemplate.update(statementUser, new Object[] { recruiter.getPassword(), recruiter.getUserName(), recruiter.getUserSurname(), recruiter.getEmail(),recruiter.getBirthday()});
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
	
	public String loginUser(User user) {
		
		
		// SQL Statement aus json lesen (Nadine Jakob 07.06.2019)
		String key = "user.login";
		String statement = jsonNode.get(key).asText();
		
		if(statement  != null) {
			try {
				String resultName = jdbcTemplate.queryForObject(statement, new Object[] {user.getEmail(), user.getPassword()}, new RowMapper<String>() {
				
				@Override
				public String mapRow(ResultSet rs, int rowNum) throws SQLException {
					String name = rs.getString("name");
					String surname = rs.getString("surname");
					return name + " " + surname;
				}
				});
				return resultName;
			} catch (Exception e) {
				return null;
			}
		} else {
			return null;
		}
	}
	
	//Prüfen ob Applicant oder Recruiter
	public int isApplicant(String email) {
		String key = "user.isApplicant";
		String statement = jsonNode.get(key).asText();
		
		if(statement  != null) {
			try {
				int resultAid = jdbcTemplate.queryForObject(statement, new Object[] {email}, int.class);
				// Ist ein Applicant
					return resultAid;
				
			} catch (EmptyResultDataAccessException e) {
				// Ist ein Recruiter
				return 0;
			} catch (Exception e) {
				return -1;
			}
		} else {
			return -1;
		}
	}


	// Applicant Profil anzeigen
	public Applicant showApplicantProfile(String email) {
		// get SQL Statement 
		String key = "applicant.showProfile";
		String statement = jsonNode.get(key).asText();
		
		if(statement != null) {
			try {
								
				Applicant result = jdbcTemplate.queryForObject(statement, new Object[] {email}, new RowMapper<Applicant>() {
					@Override
					public Applicant mapRow(ResultSet rs, int rowNum) throws SQLException {
						Applicant applicant = new Applicant();
						applicant.setEmail(rs.getString("email"));
						applicant.setEntryDate(rs.getDate("entrydate").toString());
						applicant.setSalary(rs.getString("salary"));
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
		public Recruiter showRecruiterProfile(String email) {
			// get SQL Statement 
			String key = "recruiter.showProfile";
			String statement = jsonNode.get(key).asText();
			
			if(statement != null) {
				try {
									
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
	public int changeApplicantProfile(Applicant applicant) {
		String userId = applicant.getUserId();
		
		// get SQL Statement 
		String key = "applicant.updateProfile";
		String statement = jsonNode.get(key).asText();

		if(statement != null) {
			try {
				int counter = jdbcTemplate.update(statement, new Object[] {applicant.getUserName(), applicant.getUserSurname(), applicant.getEmail(), applicant.getBirthday(), applicant.getEntryDate(), 
						applicant.getSubject(), applicant.getSpecialization(), applicant.getSalary(), applicant.getPassword(), applicant.getUserId()});
				
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
	public int changeRecruiterProfile(Recruiter recruiter) {
		
		String key = "recruiter.updateProfile";
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

	public List<Applicant> searchApp(List<String> skills) {
		String key = "applicant.search";
		String statement = jsonNode.get(key).asText();
		
		if(statement != null) {
			try {
				//List<Applicant> applicantList= jdbcTemplate.queryForList(statement, Applicant.class);
				for(String skill: skills) {
					statement = statement + skill +"=1 AND "; 
				}
				statement = statement.substring(0, statement.length()-4);

				List<Map <String, Object>> resultList = jdbcTemplate.queryForList(statement);
				List<Applicant> applicantList =  new ArrayList<Applicant>();
			    for(Map<String, Object> map : resultList) {
			    	Applicant applicant = new Applicant();
			    	int appId = (int)map.get("a_id");
			    	applicant.setA_id(appId);
			    	applicant.setUserName((String)map.get("name"));
			    	applicant.setUserSurname((String)map.get("surname"));
			    	applicant.setEmail((String)map.get("email"));
			    	Date birthday = (Date) map.get("birthday");
			    	applicant.setBirthday(birthday.toString());
			    	Date entryDate = (Date) map.get("entryDate");
			    	applicant.setEntryDate(entryDate.toString());
			    	int salary = (int)map.get("salary");
			    	applicant.setSalary(Integer.toString(salary));
			    	applicant.setSpecialization((String)map.get("specialization"));
			    	applicant.setSubject((String)map.get("subject"));
			    	
			    	applicantList.add(applicant);
			    }
				return applicantList;		
			} catch (Exception e) {
				return null;
			}
		} else {
			return null;
		}
	}
}

