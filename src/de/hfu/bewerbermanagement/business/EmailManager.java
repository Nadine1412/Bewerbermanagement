package de.hfu.bewerbermanagement.business;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
/**
 * 
 * @author Nadine Jakob
 *
 */
public class EmailManager {
	// sender und Empfänger, content, subject
	public void sendmail() throws AddressException, MessagingException, IOException{
		
		//Properties setzen
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(props, new Authenticator() { protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication("nadinejakob141293@gmail.com", ""); }
		});
		
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("nadinejakob141293@gmail.com", false));
		
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("nj93@gmx.de"));
		msg.setSubject("Test Email");
		msg.setContent("Test Email content.*", "text/html");
		msg.setSentDate(new Date());
		
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent("Test Email content", "text/html");
		
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);
		MimeBodyPart attachPart = new MimeBodyPart();
		
		attachPart.attachFile("C:\\Users\\Nadine\\Desktop\\testAnhang.txt");
		multipart.addBodyPart(attachPart);
		msg.setContent(multipart);
		Transport.send(msg);
	}

}
