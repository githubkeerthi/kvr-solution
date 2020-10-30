package com.kvr.solution.user.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kvr.solution.common.entity.Address;
import com.kvr.solution.common.entity.Name;
import com.kvr.solution.common.entity.User;
import com.kvr.solution.user.dao.UserRepository;
import com.kvr.solution.user.service.UserService;

@RestController
@CrossOrigin("http://localhost:4200")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(path ="/user-test")
	public User testUserController() {
		User user = new User();
		Name name = new Name();
		name.setFirstName("Keerthi");
		name.setLastName("Reddy");
		user.setPhone(9966537790l);
		user.setEmailId("skvr.java@gmail.com");
		Address address = new Address();
		address.setAddress1("Hno 58, Lakshmi nagar colony");
		address.setAddress2("Shaikpet nala");
		address.setCity("Hyderabad");
		address.setState("Telengana");
		address.setPincode(500008);
		user.setName(name);
		user.setAddress(address);
		User result = userService.getUserRepository().save(user);
		return result;
		
	}
	
	@RequestMapping(value = "/user/save", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody User user) {

		User userDetails = userService.save(user);
		return new ResponseEntity<User>(userDetails, HttpStatus.OK);

	}

	@RequestMapping(value = "/user/update", method = RequestMethod.POST)
	public ResponseEntity<?> updateUser(@RequestBody User user) {

	    User userDetails = userRepository.save(user);
		return new ResponseEntity<User>(userDetails, HttpStatus.OK);

	}

	@GetMapping(value = "/user/getById/{id}")
	public ResponseEntity<?> getCompanyDetailById(@PathVariable Long id) {

		Optional<User> userDetails = userRepository.findById(id);
		return new ResponseEntity<User>(userDetails.get(), HttpStatus.OK);

	}

	@GetMapping(value = "/user/getAll")
	public ResponseEntity<?> getAllCompanies() {

		List<User> usersList = userRepository.findAll();
		return new ResponseEntity<List<User>>(usersList, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/user/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deeleteRecord(@PathVariable Long id) {

		userRepository.deleteById(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);

	}
}
