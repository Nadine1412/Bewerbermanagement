package de.hfu.bewerbermanagement.email.model;

import java.io.File;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class Mail {
	
	private String mailReceiver;
	private String mailSubject;
	private String message;
	private CommonsMultipartFile attachment;
	
	//getter & setter
	public String getMailReceiver() {
		return mailReceiver;
	}
	public void setMailReceiver(String mailReceiver) {
		this.mailReceiver = mailReceiver;
	}
	public String getMailSubject() {
		return mailSubject;
	}
	public void setMailSubject(String mailSubject) {
		this.mailSubject = mailSubject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public CommonsMultipartFile getAttachment() {
		return attachment;
	}
	public void setAttachment(CommonsMultipartFile attachment) {
		this.attachment = attachment;
	}
	

}
