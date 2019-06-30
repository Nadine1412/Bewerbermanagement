package de.hfu.bewerbermanagement.model;

public class Applicant extends User {
	private String entryDate;
	private String subject;
	private String specialization;
	private String sallery;
	private int a_id;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getSallery() {
		return sallery;
	}

	public void setSallery(String sallery) {
		this.sallery = sallery;
	}

	public String getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	public int getA_id() {
		return a_id;
	}

	public void setA_id(int a_id) {
		this.a_id = a_id;
	}

	public Applicant() {
		// TODO Auto-generated constructor stub
	}

}
