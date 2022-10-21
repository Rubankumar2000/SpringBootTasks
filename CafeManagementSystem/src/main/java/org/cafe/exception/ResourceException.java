package org.cafe.exception;

import org.cafe.errMsg.errrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResourceException {
	
	ResourceException(){
		
	}
	
	public static ResponseEntity<String> postUserException(String resMsg, HttpStatus httpStatus){
		return new ResponseEntity<String>("body {\"message\":\""+resMsg+"\"} ", httpStatus);
	}

}
