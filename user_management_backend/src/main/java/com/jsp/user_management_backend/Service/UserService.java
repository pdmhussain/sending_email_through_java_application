package com.jsp.user_management_backend.Service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.user_management_backend.Repository.UserRepository;
import com.jsp.user_management_backend.dao.UserDao;
import com.jsp.user_management_backend.dto.User;
import com.jsp.user_management_backend.util.ResponseStructure;
import com.jsp.user_management_backend.util.UserConfig;

@Service
public class UserService {
	
	@Autowired
	UserDao dao;
	
	@Autowired
	UserRepository repository;
	@Autowired
	UserConfig config;
	
	
	public ResponseEntity<ResponseStructure> saveUser(User user){
		ResponseStructure structure=ResponseStructure.builder().msg("User management data stored successfully")
																.status(HttpStatus.CREATED.value())
																.data(dao.saveUser(user))
																.dateTime(LocalDateTime.now())
																.build();
		return new ResponseEntity<ResponseStructure>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure> userLogin(String email,String password)
	{
		User user=repository.findbyEmail(email);
    	if(user !=null) {
    		if(user.getPwd().equals(password)) {
    			dao.LoginMsg(email);
    			ResponseStructure structure=ResponseStructure.builder().msg("User data is found successfully")
						.status(HttpStatus.FOUND.value())
		                .data("login is successful")
		               .dateTime(LocalDateTime.now())
		               .build();
                return new ResponseEntity<ResponseStructure>(structure,HttpStatus.FOUND);
    		}
    		else {
    			dao.Invalidpwd(email);
    			ResponseStructure structure=ResponseStructure.builder().msg("User data is found successfully")
						.status(HttpStatus.NOT_FOUND.value())
		                .data("password is not found")
		               .dateTime(LocalDateTime.now())
		               .build();
                return new ResponseEntity<ResponseStructure>(structure,HttpStatus.NOT_FOUND);
    		}
    		
    	}
    	else {
    		dao.InvalidEmail(email);		
    		ResponseStructure structure=ResponseStructure.builder().msg("User data is found successfully")
					.status(HttpStatus.NOT_FOUND.value())
	                .data("password is not found")
	               .dateTime(LocalDateTime.now())
	               .build();
            return new ResponseEntity<ResponseStructure>(structure,HttpStatus.NOT_FOUND);
    	}
		
		
//		ResponseStructure structure=ResponseStructure.builder().msg("User data is found successfully")
//																.status(HttpStatus.FOUND.value())
//												                .data(dao.userLogin(email, password))
//												               .dateTime(LocalDateTime.now())
//												               .build();
//        return new ResponseEntity<ResponseStructure>(structure,HttpStatus.FOUND);
	}

}
