package de.hfu.bewerbermanagement.model;

public class Personaler extends User {

	private String enterprise;
	private String position;

	public String getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(String enterprise2) {
		this.enterprise = enterprise2;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Personaler() {
		// TODO Auto-generated constructor stub
	}

}
