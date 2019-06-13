package de.hfu.bewerbermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.cj.jdbc.Blob;

import de.hfu.bewerbermanagement.dao.UserDao;
import de.hfu.bewerbermanagement.model.PDF;

@Controller
public class UserUploadController {

	@Autowired
	private UserDao userDao;

//Mapping auf Zeile 37 in File: fileUpload.jsp
	
	@RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
	
	public ModelAndView fileUpload(
	
			// Blob ist der Datentyp für die PDF
			
			@RequestParam("file") Blob blob) {
		
		ModelAndView mv = new ModelAndView();
		
		PDF upload = new PDF();
		
		int counter = userDao.fileUpload(upload);
		
		if (counter > 0) {
			mv.addObject("msg", "File Upload successful.");
			mv.setViewName("login");
			
		} else {
			mv.addObject("msg", "Error - check the console log");
			mv.setViewName("fileUpload");
		}
		
		return mv;
		// TODO Auto-generated constructor stub
	}

}
