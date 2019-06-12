package de.hfu.bewerbermanagement.model;

import com.mysql.cj.jdbc.Blob;

public class PDF {
	
	private int data_id;
	private Blob pdf;


	public int getData_id() {
		return data_id;
	}

	public void setData_id(int data_id) {
		this.data_id = data_id;
	}

	public Blob getPdf() {
		return pdf;
	}

	public void setPdf(Blob pdf) {
		this.pdf = pdf;
	}
	
	public PDF() {

}}
