package de.hfu.bewerbermanagement.config;

import de.hfu.bewerbermanagement.dao.UserDao;
import de.hfu.bewerbermanagement.dao.UserDaoImpl;
import resources.Constants;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@EnableWebMvc
@ComponentScan("de.hfu.bewerbermanagement")
public class WebMvcConfig {

	@Bean
	InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();

		vr.setPrefix("/");
		vr.setSuffix(".jsp");
		return vr;
	}

	@Bean
	DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://192.52.34.129:3306/bewerbermanagement");
		ds.setUsername("admin");
		ds.setPassword("root123456");

		return ds;
	}

	@Bean
	public UserDao getUserDao() {
		return new UserDaoImpl(getDataSource());

	}
	
	// JsonNode f�r sqlstatements
	@Bean
	public JsonNode getJsonNode() {
		ObjectMapper objectMapper = new ObjectMapper();
		URL jsonUrl = WebMvcConfig.class.getResource("/de/hfu/bewerbermanagement/dao/sqlStatements.json");
		try {
			JsonNode jsonNode = objectMapper.readTree(new File(jsonUrl.getPath()));
			return jsonNode;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	// Properties für mail adapter
	@Bean
	public Session getEmailSession() {
		Properties props = new Properties();
		props.put("mail.smtp.auth", Constants.smtpAuth);
		props.put("mail.smtp.starttls.enable", Constants.smtpStarttls);
		props.put("mail.smtp.host", Constants.smtpHost);
		props.put("mail.smtp.ssl.trust", Constants.sslTrust);
		props.put("mail.smtp.port", Constants.smtpPort);
	
		Session session = Session.getInstance(props, new Authenticator() { protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(Constants.email, Constants.pw); }
		});
		return session;
	}

	// Beans für den File Upload (Florian Möhrle 13.06.2019)
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(1000000000);
		return multipartResolver;
	}

}
