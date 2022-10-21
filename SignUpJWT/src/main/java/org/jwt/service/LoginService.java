package org.jwt.service;

import org.jwt.dto.SignUpDto;
import org.jwt.dto.UserEntityDto;
import org.jwt.entity.Student;
import org.jwt.repository.LoginRepository;
import org.jwt.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	@Autowired
	LoginRepository loginRepository;
	
	public Student signUp(SignUpDto signUpDto) {
		Student student = new Student();
		student.setName(signUpDto.getName());
		student.setEmail(signUpDto.getEmail());
		student.setPassword(signUpDto.getPassword());
		student.setPhone(signUpDto.getPhone());
		student.setGender(signUpDto.getGender());
		
		return loginRepository.save(student);
	}

	public String login(UserEntityDto userDto) {
		Student student = loginRepository.findByEmailEqualsIgnoreCaseAndPassword(userDto.getEmail(),userDto.getPassword());
		
		if (student == null) {
			return "Login failed";
		}
		String token = JWTUtils.generateToken(student);
		return token;
	}

	public void verify(String auth) throws Exception {
		JWTUtils jwtUtils = new JWTUtils();
		System.out.println(auth);
		jwtUtils.verify(auth);
	}

}
