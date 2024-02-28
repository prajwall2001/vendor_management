package com.xworkz.vmanagement.service;

import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.vmanagement.dto.VendorEntity;
import com.xworkz.vmanagement.repository.VendorRepository;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class VendorServiceImpl implements VendorService {

	@Autowired
	private VendorRepository repo;

	public VendorServiceImpl() {
		System.out.println("Invoking VendorServiceImpl...");
	}

	@Override
	public boolean validateAndSave(VendorEntity entity) {
		System.out.println("Invoking validateAndSave....");
		System.out.println("Entity passed:" + entity);
		this.repo.save(entity);
		return true;
	}

	@Override
	public String isExistByGstNoContactNoEmailWebsite(String gstNo, Long contactNo, String email, String website) {
		VendorEntity ref = repo.isExist(gstNo, contactNo, email, website);
		if (ref != null) {
			if (ref.getGstNo().equals(gstNo)) {
				return "GstNo already exist";

			} else if (ref.getContactNo().equals(contactNo)) {
				return "Contact already exist";

			}

			else if (ref.getEmail().equals(email)) {
				return "Email already exist";

			} else if (ref.getWebsite().equals(website)) {
				return "Website already exist";

			}
			System.out.println("Deatils not found....Save the details");

		}
		return null;

	}

	@Override
	public boolean sendEmail(String email) {
		String portNumber = "587";
		String hostName = "smtp.office365.com";
		String fromEmail = "prajwalpoojary28@outlook.com";
		String password = "Prajju@2001";
		String to = email;

		Properties prop = new Properties();

		prop.put("mail.smtp.host", hostName);
		prop.put("mail.smtp.port", portNumber);
		prop.put("mail.smtp.starttls.enable", true);
		prop.put("mail.debug", true);
		prop.put("mail.smtp.auth", true);
		prop.put("mail.transport.protocol", "smtp");

		Session session = Session.getInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		});

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(fromEmail));
			message.setSubject("Registration Form");
			message.setText("Thank you for registering");

			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			Transport.send(message);

			return true;

		}

		catch (MessagingException e) {
			e.printStackTrace();
		}

		return false;

	}

	@Override
	public String findAllByGstNo(String gstNo) {
		List<String> byGstNo = this.repo.findAllByGstNo(gstNo);
		System.err.println(byGstNo);
		for (String gst : byGstNo) {
			System.out.println(gst + " checking for " + gstNo);

			if (gst.equalsIgnoreCase(gstNo)) {
				System.out.println("checking for " + gstNo);
				return "GstNo already exist.";
			}
		}

		return null;
	}


	@Override
	public String findByContactNo(Long contactNo) {

		List<Long> byContactNo = this.repo.findAllByContactNo(contactNo);
		System.err.println(byContactNo);
		for (Long contact : byContactNo) {
			System.out.println(contact + " checking for " + contactNo);

			if (contact.equals(contactNo)) {
				System.out.println("checking for " + contactNo);
				return "ContactNo already exist.";
			}
		}

		return null;
	}

	@Override
	public String findByAlternativeNo(Long alternativeNo) {
		List<Long> byAlternativeNo = this.repo.findAllByAlternativeNo(alternativeNo);
		System.err.println(byAlternativeNo);
		for (Long altContact : byAlternativeNo) {
			System.out.println(altContact + " checking for " + alternativeNo);

			if (altContact.equals(alternativeNo)) {
				System.out.println("checking for " + alternativeNo);
				return "AlternativeNo already exist.";
			}
		}

		return null;

	}

	@Override
	public String findByEmail(String email) {
		List<String> byEmail = this.repo.findAllByEmail(email);
		System.err.println(byEmail);
		for (String mail : byEmail) {
			System.out.println(mail + " checking for " + email);

			if (mail.equalsIgnoreCase(email)) {
				System.out.println("checking for " + email);
				return "Email already exist.";
			}
		}

		return null;

	}

	@Override
	public String findByWebsite(String website) {
		List<String> byWebsite = this.repo.findAllByWebsite(website);
		System.err.println(byWebsite);
		for (String web : byWebsite) {
			System.out.println(web + " checking for " + website);

			if (web.equalsIgnoreCase(website)) {
				System.out.println("checking for " + website);
				return "Website already exist.";
			}
		}

		return null;

	}
}
