package org.cafe.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface UserService {

	ResponseEntity<String> postUser(Map<String, String> reqMap);

	ResponseEntity<String> loginUser(Map<String, String> reqMap);

}
