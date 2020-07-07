package com.lms.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.entity.Employee;
import com.lms.util.DBUtil;

@RestController
public class EmployeeController {

	@RequestMapping(value="/employwwa")
	public List<Employee> getEmployeeList(){
		return DBUtil.generateEmployeeList();
	}
}
