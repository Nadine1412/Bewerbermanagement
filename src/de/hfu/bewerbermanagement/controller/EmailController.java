package de.hfu.bewerbermanagement.controller;
/**
 * 
 * @author Nadine Jakob
 *
 */
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import de.hfu.bewerbermanagement.business.EmailManager;


@Controller
public class EmailController {
	@RequestMapping(value="/sendEmailForm", method = RequestMethod.POST)
	public ModelAndView sendEmail() {
		
		ModelAndView mv = new ModelAndView();
		
		EmailManager email = new EmailManager();
		try {
			email.sendmail();
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mv.setViewName("sendEmailForm");
		return mv;
		
	}
	
	
	

}
