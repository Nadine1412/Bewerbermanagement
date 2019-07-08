package de.hfu.bewerbermanagement.skills.dao;

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


public class SkillsDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private JsonNode jsonNode;
	
	// Aufrufen des jdbcTemplate
	public SkillsDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// Fähigkeiten der Datenbank hinzufügen
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
							skills.getProgrammingLanguage().contains("HTML"), skills.getOffice().contains("Word"),
							skills.getOffice().contains("Excel"), skills.getOffice().contains("Powerpoint"),
							skills.getOffice().contains("GitHub"), skills.getOffice().contains("Jira"),
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
							skills.getProgrammingLanguage().contains("HTML"), skills.getOffice().contains("Word"),
							skills.getOffice().contains("Excel"), skills.getOffice().contains("Powerpoint"),
							skills.getOffice().contains("GitHub"), skills.getOffice().contains("Jira"),
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
	public Skills oldSkills(int a_id) {
		// get SQL Statement 
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
							programmingLanguage.add("HTML");
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
	
	// Prüfen ob Skills bereits vorhanden
	public boolean isSkillAvailable(int a_id) {
		// SQL Statement aus json lesen 
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
}

