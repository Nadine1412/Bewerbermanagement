package org.dcoders.chk;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class SelectOne {
	
	@RequestMapping(value = "/skills", method = RequestMethod.POST)
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String select[]=request.getParameterValues("chkSelect");
		
		try {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet SelectOne</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Selected values are :</h1>");
			for(int i=0;i<select.length;i++) {
				out.println("<h1>"+select[i]+"<h1>");
			}
			out.println("<body>");
			out.println("</html>");

		} finally { out.close();
		
	}
	}}
