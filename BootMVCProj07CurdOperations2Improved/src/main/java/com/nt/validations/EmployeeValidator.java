package com.nt.validations;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.model.Employee;

@Component
public class EmployeeValidator implements Validator {

	private static final Object Employee = null;

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Employee.class);
	}// THIS IS TO CHECK WHETHER  WE ARE PASISING THE CORRECT COMMAND/MODEL CLASS OR NOT 

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("EmployeeValidator.validate()==> server side form validations");
			Employee emp = (Employee)target ;
			// required rule for the ename 
		if (emp.getEname()==null || emp.getEname().length()==0 || emp.getEname().equals(""))
				errors.rejectValue("ename", "empname.required");
		else if (emp.getEname().length()>10)
			errors.rejectValue("ename", "empname.maxlength");
		// required rule for the job
		
		if (emp.getJob()==null || emp.getJob().length()==0 || emp.getJob().equals(""))
			errors.rejectValue("job", "empdesg.required");
	else if (emp.getJob().length()>10)
		errors.rejectValue("job", "empdesg.maxlength");
		
		// required rule for the salary
		

		if (emp.getEsal()==null )
			errors.rejectValue("esal", "empsal.required");
		else if (emp.getEsal()<1 || emp.getEsal()>100000)
			errors.rejectValue("esal", "empsal.range");
		
		
		
			
	}

}
// we have to develop separate validator class for every model class 