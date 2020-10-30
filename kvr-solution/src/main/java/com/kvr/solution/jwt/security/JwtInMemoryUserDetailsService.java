package com.kvr.solution.jwt.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kvr.solution.user.dao.MasterUserRepository;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService, AuditorAware<String> {

  static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();
  static String userName;
 
//  static {
//	  //username password in encoded format and user role
//    inMemoryUserList.add(new JwtUserDetails(1L, "easyapp",
//        "$2a$10$3zHzb.Npv1hfZbLEU5qsdOju/tk2je6W6PnNnY.c1ujWPcZh4PL6e", "ROLE_USER_2"));
//  }

  @Autowired
  MasterUserRepository masterUserRepository;
  
  @Override
  public JwtUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	  JwtUserDetails user = masterUserRepository.findByUsername(username);
//    Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
//        .filter(user -> user.getUsername().equals(username)).findFirst();

    if (user == null) {
      throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
    }
    
    userName=user.getUsername();
    return user;
  }

	@Override
	public Optional<String> getCurrentAuditor() {
		// TODO Auto-generated method stub
		return Optional.of(userName);
	}
	
}


