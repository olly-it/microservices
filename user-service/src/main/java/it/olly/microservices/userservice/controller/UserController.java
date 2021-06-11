package it.olly.microservices.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.olly.microservices.userservice.entity.User;
import it.olly.microservices.userservice.service.UserService;
import it.olly.microservices.userservice.vo.UserDepartmentVO;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

	@Autowired	
	private UserService userService;
	
	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		log.info("users controller - saveUser");
		return userService.saveUser(user);
	}
	
	@GetMapping("/{id}")
	public UserDepartmentVO getUserWithDepartment(@PathVariable("id") Long userId) {
		log.info("users controller - getUserWithDepartment");
		return userService.getUserWithDepartment(userId);
	}
}
