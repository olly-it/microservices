package it.olly.microservices.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import it.olly.microservices.userservice.entity.User;
import it.olly.microservices.userservice.repository.UserRepository;
import it.olly.microservices.userservice.vo.DepartmentVO;
import it.olly.microservices.userservice.vo.UserDepartmentVO;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		log.info("users service - saveUser");
		return userRepository.save(user);
	}

	public UserDepartmentVO getUserWithDepartment(Long userId) {
		log.info("users service - getUserWithDepartment");
		UserDepartmentVO vo = new UserDepartmentVO();
		User user = userRepository.findByUserId(userId);
		// DEPARTMENT-SERVICE will be resolved automatically to localhost:9001 by eureka service-registry
		// @LoadBalanced has to be added on RestTemplate. see UserServiceApplication
		DepartmentVO department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(), DepartmentVO.class);
		vo.setUser(user);
		vo.setDepartment(department);
		return vo;
	}
	
}
