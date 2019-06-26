package de.hfu.bewerbermanagement.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import de.hfu.bewerbermanagement.dao.UserDao;
import de.hfu.bewerbermanagement.model.File;

//Controller für den Upload der File (Florian Möhrle 14.06.2019)
@Controller
public class UserUploadController {
	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public ModelAndView upload(@RequestParam("name") String name, 
			@RequestParam("file") MultipartFile file,
			@RequestParam("description") String description,
			HttpSession session) {
		
		ModelAndView mv = new ModelAndView();
		
		//convertFileInByte
		if(!file.isEmpty()) {
			byte[] byteFile = new byte[(int) file.getSize()];
			InputStream in;
			try {
				in= file.getInputStream();
				in.read(byteFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//set fileModel
			File fileModel = new File();
			fileModel.setFile(byteFile);
			fileModel.setUploadDate(LocalDate.now());
			fileModel.setFilename(file.getOriginalFilename());
			fileModel.setA_id((int)session.getAttribute("a_id"));
			fileModel.setDescription(description);
			
			int result = userDao.saveFileUpload(fileModel);
			
			if(result != 0) {
				mv.addObject("msg", "Datei erfolgreich hochgeladen.");
				mv.setViewName("fileUpload");
			} else {
				mv.addObject("msg", "Datei konnte nicht hochgeladen werden.");
				mv.setViewName("fileUpload");
			}
			return mv;
		} else {
			mv.addObject("msg", "Sie haben keine Datei ausgew�hlt.");
			mv.setViewName("fileUpload");
			return mv;
		}
		
	}
}

