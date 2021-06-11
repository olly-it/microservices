package it.olly.microservices.userservice.vo;

import it.olly.microservices.userservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDepartmentVO {
	private User user;
	private DepartmentVO department;
}
