package it.olly.microservices.departmentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.olly.microservices.departmentservice.entity.Department;
import it.olly.microservices.departmentservice.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public Department saveDepartment(Department department) {
		log.info("department service - saveDepartment");
		return departmentRepository.save(department);
	}

	
	public Department findDepartmentById(Long departmentId) {
		log.info("department service - findDepartmentById");
		return departmentRepository.findByDepartmentId(departmentId);
	
	}

}
