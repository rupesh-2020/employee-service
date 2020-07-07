package com.lms.util;



import java.util.ArrayList;
import java.util.List;

import com.lms.entity.Employee;


public class DBUtil {

	public static List<Employee> generateEmployeeList(){
		List<Employee> list = new ArrayList<Employee>();
		for(int i=0; i<100; i++){
			Employee emp = new Employee("Employee_Name_"+i, (i%3), "Department_"+(i%3), ((i%5)*20000), "Designation_"+(i%7));
			list.add(emp);
		}
		return list;
	}
}
