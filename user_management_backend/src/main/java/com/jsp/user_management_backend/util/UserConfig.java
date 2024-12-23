package com.jsp.user_management_backend.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class UserConfig {
	@Autowired
	JavaMailSender sender;
	public void sendEmail(String email) {
		SimpleMailMessage msg=new SimpleMailMessage();
		msg.setFrom("pdmahammadhussain@gmail.com");
		msg.setTo(email);
		msg.setSubject("User Management Registration");
		msg.setText("Dear User, \nThankyou for registering have a nice day\nregards,\nHussain.");
		sender.send(msg);
	}
	
	public void LoginEmail(String email) {
		SimpleMailMessage msg=new SimpleMailMessage();
		msg.setFrom("pdmahammadhussain@gmail.com");
		msg.setTo(email);
		msg.setSubject("User Login Successfully");
		msg.setText("Dear User, \nyou have logged into your account \nregards,\nHussain.");
		sender.send(msg);
		
	}
	public void InvalidPwd(String email) {
		SimpleMailMessage msg=new SimpleMailMessage();
		msg.setFrom("pdmahammadhussain@gmail.com");
		msg.setTo(email);
		msg.setSubject("InCorrect Password");
		msg.setText("Dear User, \nyou have entered invalid password \nregards,\nHussain.");
		sender.send(msg);
		
	}
	public void InvalidEmail(String email)
	{
		SimpleMailMessage msg=new SimpleMailMessage();
		msg.setFrom("pdmahammadhussain@gmail.com");
		msg.setTo(email);
		msg.setSubject("Invalid Email ");
		msg.setText("Dear User, \nyou have entered mail which is not registered \nregards,\nHussain.");
		sender.send(msg);
	}

}
