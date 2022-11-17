package com.example;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {
	
	@RequestMapping(path ="/validate",method = RequestMethod.GET)
	public String validateEmp(Model m)
	{
	Employee emp=new Employee();
	m.addAttribute("emp", emp);
	return "login1";

	}
	//BindingResult-is Spring Object that holds the result of validation and binding and also contains
	// the errors.
	//@Valid-the form fields which are the properties will be validated and Spring invokes the validators
	// and put the errors inside the BindingResult Object.

	@RequestMapping(path ="/register",method = RequestMethod.POST)
	public String submitForm(@Valid @ModelAttribute("emp") Employee emp,
	BindingResult bindingResult, Model model) {
	System.out.println(emp);



	if (bindingResult.hasErrors()) {
	return "login1";
	} else {
	return "success";
	}
	}

}
