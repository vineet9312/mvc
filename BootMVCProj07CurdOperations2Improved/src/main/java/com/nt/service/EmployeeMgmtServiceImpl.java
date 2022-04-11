package com.nt.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.nt.model.Employee;
import com.nt.repo.IEmployeeRepo;


@Service("empservice")
public class EmployeeMgmtServiceImpl implements IEmployeeService {
	
	
	@Autowired
	private IEmployeeRepo repo ;
	@Override
	public List<Employee> getAllEmployees() {
		
		
		List<Employee> findAll = repo.findAll() ;
		
		return findAll ; 
		
		
	}
	@Override
	public String registerEmployee(Employee emp) {
		Integer empNo = repo.save(emp).getEmpNo() ;
		return "employee is saved with the id as ==> " + empNo ; 
	}
	
	
	// made by me for the deletion of the record 
	@Override
	public String  deletEmployeeRecord(int no) {
			
		repo.deleteById(no);
		
		return no + "=> employee is deleted " ; 
		
		
	}
	
	// this method we have specially made for the form launch while editing operation so that employee records should be coming while editing  from the database 
	@Override
	public Employee getByEmployee(int no) {
		// TODO Auto-generated method stub
		Employee employee = repo.findById(no).get() ;
		return employee  ; 
	}
	
	// this is for, hen we click on the submit button at the edit page
	@Override
	public String editEmployee(Employee emp) {
		
		Integer empNo = repo.save(emp).getEmpNo() ;
		return  empNo + "employee is updated " ;
	
	
	}
	@Override
	public Set<String> getAllCountries() {
			Locale locales[] = Locale.getAvailableLocales() ; 
			Set<String> countrySet =  new TreeSet() ; 
			for(Locale l : locales)
			{
				if(l!=null)
				{
					countrySet.add(l.getDisplayCountry()) ; 
				}
			}
			return countrySet ; 
			
	}
	// this environment is added as part of the addin the new tate list and getting some values out of it 
	@Autowired
	private Environment env ; 
	
	@Override
	public List<String> getStatesbyCountry(String country) {
	
			String statesInfo = env.getRequiredProperty(country) ;
			
			List<String> statesList = Arrays.asList(statesInfo.split(",")) ; 
			
			Collections.sort(statesList);
			return statesList; 
			
			
	
	}

}
