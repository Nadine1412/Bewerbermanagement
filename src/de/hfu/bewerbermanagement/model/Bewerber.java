package de.hfu.bewerbermanagement.model;

public class Bewerber extends User {
	private String entryDate;
	private String subject;
	private String specialization;
	private String sallery;

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

	public Bewerber() {
		// TODO Auto-generated constructor stub
	}

}
