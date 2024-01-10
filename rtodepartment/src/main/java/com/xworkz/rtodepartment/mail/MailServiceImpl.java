package com.xworkz.rtodepartment.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.xworkz.rtodepartment.configuration.MailConfiguration;

@Service
public class MailServiceImpl implements MailService {

	@Autowired
	private MailConfiguration mailConfiguration;

	@Override
	public boolean sentMail(String email, String otp) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(email);
		mailMessage.setSubject("OTP for login");
		mailMessage.setText("your otp for login is:" + otp);
		mailConfiguration.getJavaMailSender().send(mailMessage);
		System.out.println("mail sucessfully sent");
		return true;
	}

}
