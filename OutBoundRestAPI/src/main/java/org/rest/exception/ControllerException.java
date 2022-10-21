//package org.rest.exception;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//@ControllerAdvice
//public class ControllerException {
//	
//	@ExceptionHandler(RubanFileException.class)
//	public ResponseEntity<?> rubanErrorHandler(RubanFileException exception) {
//		ErrorDetails error=new ErrorDetails(exception.getMessage());
//		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
//	}
//	
//}