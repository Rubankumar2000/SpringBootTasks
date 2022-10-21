package org.cafe.controller;

import java.util.Map;

import org.cafe.entity.User;
import org.cafe.errMsg.errrorMessage;
import org.cafe.exception.ResourceException;
import org.cafe.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
	
	
	@Autowired
	UserService userService;
	
	@PostMapping("/signUp")
	public ResponseEntity<String> postUser(@RequestBody Map<String, String> reqMap) {
		try {
			return userService.postUser(reqMap);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResourceException.postUserException(errrorMessage.sww,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody Map<String, String> reqMap){
		try {
			return userService.loginUser(reqMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResourceException.postUserException(errrorMessage.sww, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
