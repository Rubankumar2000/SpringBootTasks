package org.jwt.utils;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import org.jwt.entity.Student;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtils {
	
	static Date expiryDate = new Date(System.currentTimeMillis()+10*1000*60*60); 
	public static String secret = "Rubankumar";
	
	public static String generateToken(Student student ) {
		Claims claims = Jwts.claims()
				.setIssuer(student.getName().toString())
				.setIssuedAt(student.getCreatedAt())
				.setExpiration(expiryDate);
		claims.put("email", student.getEmail());
		claims.put("phone", student.getPhone());
		claims.put("gender", student.getGender());
		System.out.println(secret);
		return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256, secret).compact();		
	}

	public void verify(String authorization) throws Exception {
		try {
			System.out.println(secret);
			Jwts.parser().setSigningKey(secret).parseClaimsJws(authorization);
			System.out.println("Try block");
		}catch(Exception e) {
			System.out.println("Catch exception");
			throw new Exception();
		}
	}
}
