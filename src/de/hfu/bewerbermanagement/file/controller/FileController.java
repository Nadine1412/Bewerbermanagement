package de.hfu.bewerbermanagement.file.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import de.hfu.bewerbermanagement.file.model.File;
import de.hfu.bewerbermanagement.skills.model.Skills;
import de.hfu.bewerbermanagement.user.dao.UserDao;
import de.hfu.bewerbermanagement.user.model.Applicant;
import de.hfu.bewerbermanagement.user.model.Recruiter;

//Controller fÃ¼r den Upload der File (Florian MÃ¶hrle 14.06.2019)
@Controller
public class FileController {
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
			mv.addObject("msg", "Sie haben keine Datei ausgewählt.");
			mv.setViewName("fileUpload");
			return mv;
		}
		
	}
	
	//Files von der Datenbank(dao) an den View weitergeben
		@RequestMapping(value = {"getFiles"}, method = RequestMethod.GET)
		public ModelAndView showFiles(HttpSession session) {
			
			int a_id  = (int) session.getAttribute("a_id");
			
			ModelAndView mv = new ModelAndView();
								
			//Aufrufen der Files
			List<de.hfu.bewerbermanagement.file.model.File> filesList = userDao.showFiles(a_id);
			// Sessionattribute für Files setzten
			session.setAttribute("files", filesList);
			
				if(filesList != null) {
					mv.addObject("filesList", filesList);	
					mv.setViewName("fileUploadView");
				} else {
					mv.addObject("msg", "Keine Files vorhanden");
					mv.setViewName("fileUploadView");
				}
		
			return mv;		
		}
		
		//Files von der JSP downloaden
				@RequestMapping(value = {"/downloadFile"}, method = RequestMethod.POST)
				public void downloadFile(@RequestParam("filename") String filename, HttpServletResponse response, HttpSession session) throws IOException {

					
					
					List<de.hfu.bewerbermanagement.file.model.File> downloadList = (List<File>) session.getAttribute("files");
					
					byte[] fileData = null;
					for(File file:downloadList) {
						if (file.getFilename().equals(filename)) {
				           fileData = file.getFile();
						}
					}
					
					InputStream in = new ByteArrayInputStream(fileData);
					ServletOutputStream out = response.getOutputStream();
					
					byte[] outputByte = new byte[fileData.length];
					//copy binary context to output stream
					while(in.read(outputByte, 0, fileData.length) != -1)
					{
						out.write(outputByte, 0, fileData.length);
					}
					in.close();
					out.flush();
					out.close();
				}
				
				//Files von der Datenbank(dao) an den View weitergeben (Recruiter)
				@RequestMapping(value = {"getSearchedFiles"}, method = RequestMethod.GET)
				public ModelAndView showSearchedFiles(HttpServletRequest request, HttpSession session) {
					
					int a_id = Integer.parseInt(request.getParameter("paramAid"));
					
					ModelAndView mv = new ModelAndView();
										
					//Aufrufen der Files
					List<de.hfu.bewerbermanagement.file.model.File> filesList = userDao.showFiles(a_id);
					// Sessionattribute für Files setzten
					session.setAttribute("files", filesList);
					
						if(filesList.size() > 0) {
							mv.addObject("filesList", filesList);
							mv.setViewName("applicantFiles");
						} else {
							mv.addObject("msg", "Keine Files für diesen Bewerber vorhanden.");
							mv.setViewName("applicantFiles");
						}
				
					return mv;		
				}
				
}

