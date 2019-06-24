package de.hfu.bewerbermanagement.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

//import java.io.IOException;
//import java.io.InputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import de.hfu.bewerbermanagement.dao.UserDao;
import de.hfu.bewerbermanagement.model.File;

//Controller für den Upload der File (Florian Möhrle 14.06.2019)
@Controller
public class UserUploadController {
	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public String upload(@RequestParam("name") String name, 
			@RequestParam("file") MultipartFile file,
			HttpSession session) {
		
		
			
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
			fileModel.setDescription("nix");
			
			int result = userDao.saveFileUpload(fileModel);
			
			
			
//			String path = session.getServletContext().getRealPath("/");
//			String filename = file.getOriginalFilename();
//			
//			System.out.println(path + ""+filename);
			try {


				return "You successfully uploaded file=" + name;
			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		} else {
			return "You failed to upload " + name
					+ " because the file was empty.";
		}
	}
	
//	BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(path+"/"+filename));
//	
//	bout.write(bytes);
//	bout.flush();
//	bout.close();

//	public String submit(@RequestParam("file") MultipartFile file, ModelMap modelMap) {
//		modelMap.addAttribute("file", file);
//		return "fileUploadView";

		// !Hier soll die Blob File in Byte Array umgewandelt werden um sie in die DB zu
		// schreiben!

//		byte[] byteFile = new byte[(int)modelMap.size()];
//		InputStream in;
//		try {
//			in= uploadedFile.getInputStream();
//			in.read(byteFile);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		// !Hier soll der Eintrag in die DB Stattfinden!

//		String sql = "INSERT INTO ... (...) VALUES(?,?,?,?,?,?,?,?)";
//
//		try {
////			int counter = jdbcTemplate.update(sql, new Object[] {...});
//			int counter = jdbcTemplate.update(sql, new Object[] { ...});
//
//			return counter;
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		return null;
	}

