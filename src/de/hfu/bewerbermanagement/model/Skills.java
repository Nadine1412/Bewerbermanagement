package de.hfu.bewerbermanagement.model;

import java.util.List;

public class Skills {
	private List<String> programmingLanguage;
	private List<String> office;
	private List<String> language;

	

	public List<String> getProgrammingLanguage() {
		return programmingLanguage;
	}



	public void setProgrammingLanguage(List<String> programmingLanguage) {
		this.programmingLanguage = programmingLanguage;
	}



	public List<String> getOffice() {
		return office;
	}



	public void setOffice(List<String> office) {
		this.office = office;
	}



	public List<String> getLanguage() {
		return language;
	}



	public void setLanguage(List<String> language) {
		this.language = language;
	}



	public Skills() {
		// TODO Auto-generated constructor stub
	}

}
