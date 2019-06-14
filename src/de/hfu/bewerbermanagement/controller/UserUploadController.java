package de.hfu.bewerbermanagement.controller;

//import java.io.IOException;
//import java.io.InputStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

//Controller für den Upload der File (Florian Möhrle 14.06.2019)
@Controller
public class UserUploadController {

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public String submit(@RequestParam("file") MultipartFile file, ModelMap modelMap) {
		modelMap.addAttribute("file", file);
		return "fileUploadView";

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
}
