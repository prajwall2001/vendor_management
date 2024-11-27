package com.xworkz.vmanagement.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Controller;

@Controller
public class EmailSender {

	public EmailSender() {
		System.out.println("invoking the EmailSender()");
	}

	public boolean emailSender(String to, String from, String subject, String text) {
		String portNumber = "587";
		String hostName = "smtp.office365.com";
		String fromEmail = from;
		String password = "Prajju@2001";

		Properties prop = new Properties();

		prop.put("mail.smtp.host", hostName);
		prop.put("mail.smtp.port", portNumber);
		prop.put("mail.smtp.starttls.enable", true);
		prop.put("mail.debug", true);
		prop.put("mail.smtp.auth", true);
		prop.put("mail.transport.protocol", "smtp");


		Session session=Session.getInstance(prop, new Authenticator() {

	
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
			
		});

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(fromEmail));
			message.setSubject(subject);
			message.setText(text);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			Transport.send(message);
			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		System.out.println("Email Send Successfully");
		return false;
	}
}
