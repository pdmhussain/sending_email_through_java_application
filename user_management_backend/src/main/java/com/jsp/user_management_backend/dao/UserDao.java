package com.jsp.user_management_backend.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.user_management_backend.Repository.UserRepository;
import com.jsp.user_management_backend.dto.User;
import com.jsp.user_management_backend.util.UserConfig;

@Repository
public class UserDao {
	
	@Autowired
	UserRepository repository;
	@Autowired
	UserConfig config;
	
	public User saveUser(User user) {
		sendMsg(user.getEmail());
		return repository.save(user);
	}
	public String sendMsg(String email) {
		try {
			config.sendEmail(email);
			return "sent successfully";
		}catch(Exception e) {
			return "Internal error";
		}
	}
	
	 public String userLogin(String email,String pwd) {
	    	User user=repository.findbyEmail(email);
	    	if(user !=null) {
	    		if(user.getPwd().equals(pwd)) {
	    			LoginMsg(email);
	    			return "login success";
	    		}
	    		else
	    			Invalidpwd(email);
	    			return "password mismatch";
	    		
	    	}
	    	else
	    		InvalidEmail(email);		
	    		return " email not found";
	    }
	 public String LoginMsg(String email) {
			try {
				config.LoginEmail(email);
				return "Logged succesfully";
			}catch(Exception e) {
				return "Internal error";
			}
		}
	 public String Invalidpwd(String email) {
			try {
				config.InvalidPwd(email);
				return "Invalid password";
			}catch(Exception e) {
				return "Internal error";
			}
		}
	 public String InvalidEmail(String email) {
			try {
				config.InvalidEmail(email);
				return "Email is not registered";
			}catch(Exception e) {
				return "Internal error";
			}
		}
	 

}
