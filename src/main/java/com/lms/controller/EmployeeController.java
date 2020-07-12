package com.lms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.entity.Employee;
import com.lms.util.DBUtil;

@RestController
public class EmployeeController {

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployeeList(){
		List<Employee> list = DBUtil.generateEmployeeList();
		ResponseEntity<List<Employee>> entity = new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
		return entity;
	}
}
