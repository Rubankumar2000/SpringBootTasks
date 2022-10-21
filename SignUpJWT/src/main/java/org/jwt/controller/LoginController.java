package org.jwt.controller;

import org.jwt.dto.SignUpDto;
import org.jwt.dto.UserEntityDto;
import org.jwt.entity.Student;
import org.jwt.service.LoginService;
import org.jwt.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	JWTUtils jwtUtils;
	
	@PostMapping("/signup")
	public ResponseEntity<Student> signUp(@RequestBody SignUpDto signUpDto){
		return ResponseEntity.status(200).body(loginService.signUp(signUpDto));
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody UserEntityDto userDto){
		return ResponseEntity.status(200).body(loginService.login(userDto));
	}
	
	@GetMapping("private")
	public ResponseEntity<String> privateApi(@RequestHeader(value = "auth", defaultValue = "") String auth) throws Exception{
//		loginService.verify(auth);
		jwtUtils.verify(auth);
		return ResponseEntity.status(200).body(auth);
	}

}
