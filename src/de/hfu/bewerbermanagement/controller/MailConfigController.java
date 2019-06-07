package de.hfu.bewerbermanagement.controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import de.hfu.bewerbermanagement.business.EmailManager;
import de.hfu.bewerbermanagement.mailAdapter.MailConfig;
/**
 * 
 * @author Nadine Jakob
 *
 */
public class MailConfigController {
	
	@RequestMapping(value="/mailConfig", method = RequestMethod.POST)
	public ModelAndView mailConfig(@RequestParam("smtpHost") String smtpHost, @RequestParam("smtpPort") String smtpPort) {
		
		ModelAndView mv = new ModelAndView();
		
		MailConfig mailConfig = new MailConfig();
		
		mailConfig.setSmtpHost(smtpHost);
		mailConfig.setSmtpPort(smtpPort);
		
		
		mv.setViewName("success");
		return mv;
		
	}
}
