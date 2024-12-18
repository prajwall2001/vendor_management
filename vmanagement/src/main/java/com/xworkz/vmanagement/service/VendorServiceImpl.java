package com.xworkz.vmanagement.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.vmanagement.dto.VendorDto;
import com.xworkz.vmanagement.entity.VendorEntity;
import com.xworkz.vmanagement.repository.VendorRepository;





@Service
public class VendorServiceImpl implements VendorService {

	@Autowired
	private VendorRepository repo;

	public VendorServiceImpl() {
		System.out.println("Invoking VendorServiceImpl...");
	}

	@Override
	public boolean validateAndSave(VendorDto vendorDto) {
		System.out.println("Invoking validateAndSave....");
		System.out.println("Entity passed:" + vendorDto);
		vendorDto.setCreatedDate(LocalDate.now());
		vendorDto.setCreatedBy(vendorDto.getName());
		vendorDto.setStatus(vendorDto.getStatus());
		VendorEntity entity=new VendorEntity();
		BeanUtils.copyProperties(vendorDto, entity);
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
		List<VendorEntity> byGstNo = this.repo.findAll();
		System.err.println(byGstNo);
		for (VendorEntity dto : byGstNo) {
			System.out.println(dto + " checking for " + gstNo);

			if (dto.getGstNo().equalsIgnoreCase(gstNo)) {
				System.out.println("checking for " + gstNo);
				return "GstNo already exist.";
			}
		}

		return null;
	}

	@Override
	public String findByContactNo(Long contactNo) {

		List<VendorEntity> byContactNo = this.repo.findAll();
		System.err.println(byContactNo);
		for (VendorEntity dto : byContactNo) {
			System.out.println(dto + " checking for " + contactNo);

			if (dto.getContactNo().equals(contactNo)) {
				System.out.println("checking for " + contactNo);
				return "ContactNo already exist.";
			}
		}

		return null;
	}

	@Override
	public String findByAlternativeNo(Long alternativeNo) {
		List<VendorEntity> byAlternativeNo = this.repo.findAll();
		System.err.println(byAlternativeNo);
		for (VendorEntity dto : byAlternativeNo) {
			System.out.println(dto + " checking for " + alternativeNo);

			if (dto.getAlternativeNo().equals(alternativeNo)) {
				System.out.println("checking for " + alternativeNo);
				return "AlternativeNo already exist.";
			}
		}

		return null;

	}

	@Override
	public String findEmail(String email) {
		List<VendorEntity> byEmail = this.repo.findAll();
		System.err.println(byEmail);
		for (VendorEntity dto : byEmail) {
			System.out.println(dto + " checking for " + email);

			if (dto.getEmail().equalsIgnoreCase(email)) {
				System.out.println("checking for " + email);
				return "Email already exist.";
			}
		}

		return null;

	}

	@Override
	public String findByWebsite(String website) {
		List<VendorEntity> byWebsite = this.repo.findAll();
		System.err.println(byWebsite);
		for (VendorEntity dto : byWebsite) {
			System.out.println(dto + " checking for " + website);

			if (dto.getWebsite().equalsIgnoreCase(website)) {
				System.out.println("checking for " + website);
				return "Website already exist.";
			}
		}

		return null;

	}

	@Override
	public String isExist(String email, String otp) {
		VendorEntity ref = repo.isExistByEmailOtp(email, otp);
		if (ref != null) {
			if (ref.getEmail().equals(email)) {
				return "Email already exist";

			} else if (ref.getOtp().equals(otp)) {
				return "Otp already exist";

			}
			System.out.println("Deatils not found....Save the details");

		}
		return null;

	}

	@Override
	public VendorEntity findByEmail(String email) {
		VendorEntity ref = repo.findByEmail(email);
		if (ref != null) {
			System.out.println("entity found");
			return ref;
		}
		return null;
	}

	@Override
	public void updateVendorStatusById(int id) {
		System.out.println("Invoking updateVendorStatusById in VendorServiceImpl..");
        repo.updateStatusById(id);

	}

}
