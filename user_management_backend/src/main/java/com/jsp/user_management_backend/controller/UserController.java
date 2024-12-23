package com.jsp.user_management_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.user_management_backend.Service.UserService;
import com.jsp.user_management_backend.dto.User;
import com.jsp.user_management_backend.util.ResponseStructure;
import com.jsp.user_management_backend.util.UserConfig;

@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.PUT, RequestMethod.GET })
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserConfig config;
	@Autowired
	UserService service;

	@PostMapping("/save")
	public ResponseEntity<ResponseStructure> saveUser(@RequestBody User user) {

		return service.saveUser(user);
	}

	@GetMapping("/login")
	public ResponseEntity<ResponseStructure> userLogin(@RequestParam String email, @RequestParam String pwd) {

//		System.out.println(email + " " + pwd);

//		return null;
		return service.userLogin(email, pwd);
	}

}
