package de.hfu.bewerbermanagement.model;

public class Recruiter extends User {

	private String enterprise;
	private String position;

	public String getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(String enterprise) {
		this.enterprise = enterprise;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Recruiter() {
		// TODO Auto-generated constructor stub
	}

}
