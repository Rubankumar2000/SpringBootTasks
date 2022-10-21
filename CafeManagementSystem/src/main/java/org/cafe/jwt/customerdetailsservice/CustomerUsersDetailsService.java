package org.cafe.jwt.customerdetailsservice;

import java.util.ArrayList;
import java.util.Objects;


import org.cafe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerUsersDetailsService implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;
	
	private org.cafe.entity.User userDetail; 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("Inside loadUserByUsername {}",username);
		userDetail = userRepository.findByEmailId(username);
		if(!Objects.isNull(userDetail)) {
			return new User(userDetail.getEmail(),userDetail.getPassword(), new ArrayList<>());
		}
		else {
			throw new UsernameNotFoundException("User not found");
		}
	}
	
	public org.cafe.entity.User getUserDetail(){
		return userDetail;
	}
	
}
