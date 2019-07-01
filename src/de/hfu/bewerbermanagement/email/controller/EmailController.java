package de.hfu.bewerbermanagement.email.controller;
/**
 * 
 * @author Nadine Jakob
 *
 */
import java.io.IOException;
import java.util.Date;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import de.hfu.bewerbermanagement.mail.model.Mail;
import resources.Constants;

@Controller
public class EmailController {
	@Autowired
	private Session getEmailSession;
	
	@RequestMapping(value="/sendEmailForm", method = RequestMethod.POST)
	public ModelAndView sendEmail(@RequestParam("mailReceiver") String mailReceiver, 
			@RequestParam("mailSubject") String mailSubject,
			@RequestParam("message") String message, 
			@RequestParam("mailAttachment") CommonsMultipartFile attachment) {
		
		ModelAndView mv = new ModelAndView();
		
		Mail mail = new Mail();
		mail.setMailReceiver(mailReceiver);
		mail.setMailSubject(mailSubject);
		mail.setMessage(message);
		mail.setAttachment(attachment);
		
		//String uploadURL = mail.getAttachment().getOriginalFilename();
		//String file = mail.getAttachment().getName();
		//String storage = mail.getAttachment().getFileItem().
		//System.out.println(storage);
		
	
		try {
			sendMail(mail);
			mv.addObject("msg", "Ihre EMail wurde erfolgreich versendet.");
			mv.setViewName("emailForm");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return mv;
		
	}

	private void sendMail(Mail mail) throws IOException {
				
		Message msg = new MimeMessage(getEmailSession);
		try {
			msg.setFrom(new InternetAddress(Constants.email, false));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail.getMailReceiver()));
			msg.setSubject(mail.getMailSubject());
			msg.setContent(mail.getMessage(), "text/html");
			msg.setSentDate(new Date());
			
			//MimeBodyPart messageBodyPart = new MimeBodyPart();
			//messageBodyPart.setContent(mail.getMessage(), "text/html");
			
//			Multipart multipart = new MimeMultipart();
//			multipart.addBodyPart(messageBodyPart);
//			MimeBodyPart attachPart = new MimeBodyPart();
//			
//			attachPart.attachFile(mail.getAttachment().getStorageDescription());
//			multipart.addBodyPart(attachPart);
//			msg.setContent(multipart);
			Transport.send(msg);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@RequestMapping(value="/getEmail", method = RequestMethod.POST)
	public ModelAndView selectedEmail(@RequestParam("mailReceiver") String mailReceiver) {
		
		ModelAndView mv = new ModelAndView();
		
			mv.addObject("paramEmail", mailReceiver);
			mv.setViewName("emailForm");
				
		return mv;
		
	}
	

}
