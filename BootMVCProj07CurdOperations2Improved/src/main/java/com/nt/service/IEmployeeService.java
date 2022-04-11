package com.nt.service;

import java.util.List;
import java.util.Set;

import com.nt.model.Employee;

public interface IEmployeeService {
	
	
	public List<Employee>getAllEmployees() ; 
	
	public String registerEmployee(Employee emp) ; 
	
	public String deletEmployeeRecord(int no);
	
	public Employee getByEmployee(int no) ; 
	
	public String editEmployee(Employee emp) ; 
	
	public Set<String> getAllCountries() ; 
	
	public List<String> getStatesbyCountry(String Country) ; 
	
}
