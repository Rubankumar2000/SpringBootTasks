package org.cafe.serivceImpl;

import java.util.Map;
import java.util.Objects;

import org.cafe.controller.UserController;
import org.cafe.entity.User;
import org.cafe.errMsg.errrorMessage;
import org.cafe.exception.ResourceException;
import org.cafe.jwt.JwtUtils;
import org.cafe.jwt.customerdetailsservice.CustomerUsersDetailsService;
import org.cafe.repository.UserRepository;
import org.cafe.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
	
	
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	CustomerUsersDetailsService customerUsersDetailsService;
	
	@Autowired
	JwtUtils jwtUtils;

	@Override
	public ResponseEntity<String> postUser(Map<String, String> reqMap) {
		logger.info("Inside signup {}",reqMap);
//		System.out.println("Inside Post method");
		try {
		if(vallidatePostUser(reqMap)) {
			User user = userRepository.findByEmailId(reqMap.get("email"));
//			System.out.println(user);
			if(Objects.isNull(user)) {
				userRepository.save(getUserFromMap(reqMap));
				return ResourceException.postUserException("Successfully Registered", HttpStatus.OK);
			}
			else {
				return ResourceException.postUserException("Email id is already exists", HttpStatus.BAD_REQUEST);
			}
		}
		else {
			ResourceException.postUserException(errrorMessage.invalid, HttpStatus.BAD_REQUEST);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ResourceException.postUserException(errrorMessage.sww, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public boolean vallidatePostUser(Map<String, String> reqMap) {
		if (reqMap.containsKey("name") && reqMap.containsKey("phone") && reqMap.containsKey("password")
				&& reqMap.containsKey("email")) {
			return true;
		}
		return false;
	}
	
	public User getUserFromMap(Map<String, String> reqMap) {
		User user = new User();
		user.setName(reqMap.get("name"));
		user.setEmail(reqMap.get("email"));
		user.setPhone(reqMap.get("phone"));
		user.setPassword(reqMap.get("password"));
		user.setStatus(reqMap.get("status"));
		user.setRole(reqMap.get("role"));
		return user;
	}

	@Override
	public ResponseEntity<String> loginUser(Map<String, String> reqMap) {
		log.info("Inside Login");
		try {
			 Authentication auth = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(reqMap.get("email"), reqMap.get("password")));
			 if(auth.isAuthenticated()) {
				 if(customerUsersDetailsService.getUserDetail().getStatus().equalsIgnoreCase("true")) {
					 return new ResponseEntity<String>("{\"token\":\""
				 +jwtUtils.generateToken(customerUsersDetailsService.getUserDetail().getEmail(),
						 customerUsersDetailsService.getUserDetail().getRole())+"\"}",HttpStatus.OK);
				 }
				 else {
					 return new ResponseEntity<String>("{\"message\":\""+"Wait for admin approval."+"\"}",HttpStatus.BAD_REQUEST);
				 }
			 }
		} catch (Exception e) {
			log.error("{}",e);
		}
		 return new ResponseEntity<String>("{\"message\":\""+"Bad Credentials."+"\"}",HttpStatus.BAD_REQUEST);
	}

}
