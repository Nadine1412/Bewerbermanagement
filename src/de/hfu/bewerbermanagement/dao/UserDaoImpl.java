package de.hfu.bewerbermanagement.dao;

import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import de.hfu.bewerbermanagement.model.Applicant;
import de.hfu.bewerbermanagement.model.Recruiter;
import de.hfu.bewerbermanagement.model.Skills;
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
		String keyUser = "user.register";
		String keyApplicant = "applicant.register";
		String statementUser = jsonNode.get(keyUser).asText();
		String statementApplicant = jsonNode.get(keyApplicant).asText();

		if(statementUser != null) {
			try {
				int counterUser = jdbcTemplate.update(statementUser, new Object[] { applicant.getPassword(), applicant.getUserName(), applicant.getUserSurname(), applicant.getEmail(),applicant.getBirthday()});
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
	
	@Override
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
	@Override
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
	@Override
	public Applicant showApplicantProfile(String email) {
		// get SQL Statement (Nadine Jakob 10.06.2019)
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
		public Recruiter showRecruiterProfile(String email) {
			// get SQL Statement (Nadine Jakob 10.06.2019)
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
	@Override
	public int changeApplicantProfile(Applicant applicant) {
		String userId = applicant.getUserId();
		
		// get SQL Statement (Nadine Jakob 10.06.2019)
		String key = "applicant.updateProfile";
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

	// Skills hinzufügen
	@Override
	public int addSkills(Skills skills, int a_id) {
		boolean isSkillAvailable = isSkillAvailable(a_id);
		String keyUpdateSkills;
		String keyInsertSkills;
		
		String statementUpdateSkills;
		String statementInsertSkills;
		
		if(isSkillAvailable) {
			keyUpdateSkills = "skills.update";
			statementUpdateSkills = jsonNode.get(keyUpdateSkills).asText();

			if(statementUpdateSkills != null) {
				try {
					int counterSkill = jdbcTemplate.update(statementUpdateSkills, new Object[] {
							skills.getProgrammingLanguage().contains("Java"), skills.getProgrammingLanguage().contains("JavaScript"),
							skills.getProgrammingLanguage().contains("C++"), skills.getProgrammingLanguage().contains("Python"),
							skills.getProgrammingLanguage().contains("Html"), skills.getOffice().contains("Word"),
							skills.getOffice().contains("Excel"), skills.getOffice().contains("Powerpoint"),
							skills.getOffice().contains("Git"), skills.getOffice().contains("Jira"),
							skills.getLanguage().contains("Deutsch"), skills.getLanguage().contains("Englisch"),
							skills.getLanguage().contains("Spanisch"), skills.getLanguage().contains("Franzoesisch"),
							skills.getLanguage().contains("Chinesisch"), a_id});
					return counterSkill;
				} catch(Exception e) {
					e.printStackTrace();
				}
				return 0;
			} else {
				return 0;
			}
		} else {
			keyInsertSkills = "skills.insert";
			statementInsertSkills = jsonNode.get(keyInsertSkills).asText();

			if(statementInsertSkills != null) {
				try {
					int counterSkill = jdbcTemplate.update(statementInsertSkills, new Object[] { 
							skills.getProgrammingLanguage().contains("Java"), skills.getProgrammingLanguage().contains("JavaScript"),
							skills.getProgrammingLanguage().contains("C++"), skills.getProgrammingLanguage().contains("Python"),
							skills.getProgrammingLanguage().contains("Html"), skills.getOffice().contains("Word"),
							skills.getOffice().contains("Excel"), skills.getOffice().contains("Powerpoint"),
							skills.getOffice().contains("Git"), skills.getOffice().contains("Jira"),
							skills.getLanguage().contains("Deutsch"), skills.getLanguage().contains("Englisch"),
							skills.getLanguage().contains("Spanisch"), skills.getLanguage().contains("Franzoesisch"),
							skills.getLanguage().contains("Chinesisch"), a_id});
					return counterSkill;
				} catch(Exception e) {
					e.printStackTrace();
				}
				return 0;
			} else {
				return 0;
			}
		}
		
	}
	
	//Skill-Profil anzeigen
	@Override
	public Skills oldSkills(int a_id) {
		// get SQL Statement (Nadine Jakob 10.06.2019)
		String key = "skills.show";
		String statement = jsonNode.get(key).asText();
		
		if(statement != null) {
			try {
				
				Skills result = jdbcTemplate.queryForObject(statement, new Object[] {a_id}, new RowMapper<Skills>() {
					
					@Override
					public Skills mapRow(ResultSet rs, int rowNum) throws SQLException {
						
						boolean java = rs.getBoolean("java");
						boolean javaScript = rs.getBoolean("javaScript");
						boolean cPlusPlus = rs.getBoolean("cPlusPlus");
						boolean python = rs.getBoolean("python");
						boolean html = rs.getBoolean("html");
						
						boolean word = rs.getBoolean("word");
						boolean excel = rs.getBoolean("excel");
						boolean powerpoint = rs.getBoolean("powerpoint");
						boolean git = rs.getBoolean("git");
						boolean jira = rs.getBoolean("jira");
						
						boolean german = rs.getBoolean("german");
						boolean english = rs.getBoolean("english");
						boolean spanish = rs.getBoolean("spanish");
						boolean french = rs.getBoolean("french");
						boolean chinese = rs.getBoolean("chinese");
						
						List<String> programmingLanguage = new ArrayList<String>();
						List<String> office = new ArrayList<>();
						List<String> language = new ArrayList<>();
						
						if(java == true) {
						programmingLanguage.add("Java");
						}
						if(javaScript == true) {
							programmingLanguage.add("JavaScript");
						}
						if(cPlusPlus == true) {
							programmingLanguage.add("C++");
						}
						if(python == true) {
							programmingLanguage.add("Python");
						}
						if(html == true) {
							programmingLanguage.add("HTML/CSS");
						}
							
						if(word == true) {
							office.add("Word");
						}
						if(excel == true) {
							office.add("Excel");
						}
						if(powerpoint == true) {
							office.add("PowerPoint");
						}
						if(git == true) {
							office.add("GitHub");
						}
						if(jira == true) {
							office.add("Jira");
						}
					
						if(german == true) {
							language.add("Deutsch");
						}
						if(english == true) {
							language.add("Englisch");
						}
						if(spanish == true) {
							language.add("Spanisch");
						}
						if(french == true) {
							language.add("Französisch");
						}
						if(chinese == true) {
							language.add("Chinesisch");
						}
							
							
						Skills skills = new Skills();
						skills.setProgrammingLanguage(programmingLanguage);
						skills.setOffice(office);
						skills.setLanguage(language);
						
						return skills;
					}
					});
				return result;
				
			}catch (Exception e) {
				return null;
			}
		} else {
			return null;
		}
		
	}
	
	
	@Override
	public boolean isSkillAvailable(int a_id) {
		// SQL Statement aus json lesen (Nadine Jakob 07.06.2019)
		String keySkills = "skills.isAvailable";
		String statementSkills = jsonNode.get(keySkills).asText();

		if(statementSkills != null) {
			try {
				int resultAid = jdbcTemplate.queryForObject(statementSkills, new Object[] {a_id}, int.class);
				// Ist ein Applicant
				if(resultAid>0) {
					return true;
				} else {
					return false;
				}
				
			} 
			catch(EmptyResultDataAccessException e) {
				return false;
			}
			catch(Exception e) {
				e.printStackTrace();	
			}
			return false;
		} else {
			return false;
		}
	}


	@Override
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
			    	applicant.setUserName((String)map.get("name"));
			    	applicant.setUserSurname((String)map.get("surname"));
			    	applicant.setEmail((String)map.get("email"));
			    	Date birthday = (Date) map.get("birthday");
			    	applicant.setBirthday(birthday.toString());
			    	Date entryDate = (Date) map.get("entryDate");
			    	applicant.setEntryDate(entryDate.toString());
			    	int sallery = (int)map.get("sallery");
			    	applicant.setSallery(Integer.toString(sallery));
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

	@Override
	public int saveFileUpload(de.hfu.bewerbermanagement.model.File f) {
		String key = "file.upload";
		String statement = jsonNode.get(key).asText();

		if(statement != null) {
			try {
				//int counter = 0;
				int counter = jdbcTemplate.update(statement, new Object[] {f.getFilename(), f.getFile(), f.getDescription(), f.getUploadDate(), f.getA_id()});
				
				return counter;
				}
				catch (Exception e) {
					return 0;
				}
		} else {
			return 0;
		}
	}


	@Override
	public de.hfu.bewerbermanagement.model.File showFiles(int a_id) {
		
		// get SQL Statement (Nadine Jakob 10.06.2019)
				String key = "file.show";
				String statement = jsonNode.get(key).asText();
				
				if(statement != null) {
					try {
										
						File result = jdbcTemplate.queryForObject(statement, new Object[] {a_id}, new RowMapper<File>() {
							@Override
							public File mapRow(ResultSet rs, int rowNum) throws SQLException {
								// File file = new File();
								Blob file =  rs.getBlob("file_data");
								System.out.println(file);
								// file.setFile(rs.getString("file_data"));
								return null;
							}
						} );	
						return null;		
					} catch (Exception e) {
						return null;
					}
				} else {
					return null;
				}
			}
	
}

