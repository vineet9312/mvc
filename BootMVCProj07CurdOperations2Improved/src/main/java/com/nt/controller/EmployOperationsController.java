package com.nt.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employee;
import com.nt.service.IEmployeeService;
import com.nt.validations.EmployeeValidator;

@Controller
public class EmployOperationsController {

	@Autowired
	private IEmployeeService service;

	@Autowired
	private EmployeeValidator empValidator ; 

	@GetMapping("/")
	public String showHome()

	{
		System.out.println("welcomee to this controller");
		return "home";

	}

	@GetMapping("/report")
	public String showEmployeData(Map<String, Object> map) {
		System.out.println("EmployOperationsController.showEmployeData()");
		List<Employee> allEmployees = service.getAllEmployees();

		map.put("empData", allEmployees);
		return "emp_report";

	}
		// add employee form launch model controller method
	@GetMapping("/add")
	public String showAddEmployeeForm(@ModelAttribute("emp") Employee emp) {
		emp.setJob("clerk");
		return "employee_register";

	}

	@PostMapping("/add")
	public String addEmployeeForm(RedirectAttributes attrs, @ModelAttribute("emp") Employee emp, BindingResult errors)
	{
		System.out.println("EmployOperationsController.addEmployeeForm()");			// BindingResult errors
																					// used for server side validation

		if(emp.getVflag().equalsIgnoreCase("no"))
		{
			if(empValidator.supports(emp.getClass()))
				empValidator.validate(emp, errors) ; 
			if(errors.hasErrors())
			{
				return "employee_register"  ; 
			}
		}

		String result = service.registerEmployee(emp) ;

		attrs.addFlashAttribute("resultMsg", result) ; 
		return "redirect:report" ; 

	}

	/*	@PostMapping("/add")
		public String addEmployeeForm(HttpSession sess, @ModelAttribute("emp") Employee emp)
		{
			System.out.println("EmployOperationsController.addEmployeeForm()");
			String result = service.registerEmployee(emp) ;

			List<Employee> list = service.getAllEmployees() ;
			map.put("empData" , list); 

			sess.setAttribute("resultMsg", result) ; 
			return "redirect:report" ; 

		}*/

	@GetMapping("/edit")
	public String showEditEmployeeForm(@RequestParam("no") int no, @ModelAttribute("emp") Employee emp) {

		Employee emp1 = service.getByEmployee(no);
		BeanUtils.copyProperties(emp1, emp);

		return "emp_edit";

	}

	@PostMapping("/edit")
	public String editEmployeeForm(RedirectAttributes attrs, @ModelAttribute("emp") Employee emp, BindingResult errors) {

		if(emp.getVflag().equalsIgnoreCase("no"))
		{	
			if(empValidator.supports(emp.getClass()))
				empValidator.validate(emp, errors) ; 
			if(errors.hasErrors())
			{
				return "emp_edit"  ; 
			}
		}
		String msg = service.editEmployee(emp);

		attrs.addFlashAttribute("resultMsg", msg);
		return "redirect:report";

	}

	// written by me for the practice of the deletion
	@GetMapping("/delete")
	public String deleteEmployRecord(RedirectAttributes attrs, @RequestParam("no") int empNo) {

		String deletEmployeeRecord = service.deletEmployeeRecord(empNo);

		attrs.addFlashAttribute("resultMsg", deletEmployeeRecord);
		return "redirect:report";
	}

	
	@ModelAttribute("countriesInfo") //' this method is called automatically just like @initbinder method by the dispatcher servlet 
	public Set<String> poplulateCountries()
	{
		System.out.println("EmployOperationsController.poplulateCountries()");
		Set<String> allCountries = service.getAllCountries() ;
		return allCountries ; 
	}
	
	
	@PostMapping("statesUrl")
	public String showstatesByCountry(@RequestParam("country") String country, @ModelAttribute("emp") Employee emp , Map<String,Object> map)
	{
		System.out.println("EmployOperationsController.showstatesByCountry()");
		List<String> statesbyCountry = service.getStatesbyCountry(country) ;
		
		map.put("statesInfo", statesbyCountry) ; 
		return "employee_register" ; 
	}
	/*
	when we click on the submit button at the register page, in this case we have the post mode request  and the data which is submitted 
	is coming to the browser after the submission  hence for this we are using the 
	map paramteer inside the controller method , also it has the post mode request 
	but 
	 for the edit link where we have the data coming from the db  as model class object
	 so in this case we dont have to use map, but we have to use the modelAttribute
	for 2 way data  binding inside the checkboxes for the form page
	 */

	/*	if business logic is used then in that case we can have the data renedering  and we have to use the map as the paramter 
		but for the edit link when there is not usage fo the businss logic to display the results , we are requireed to 
		have the 2 way binding , hence in this case we have  to use the model attribute annotation 
	 */

}
