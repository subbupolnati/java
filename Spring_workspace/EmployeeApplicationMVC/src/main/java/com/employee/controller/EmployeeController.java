package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.employee.dao.EmployeeDAO;
import com.employee.model.Employee;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeDAO edao;
	@RequestMapping("/empform")
	public String showform(Model m){    
	    m.addAttribute("command", new Employee());  
	    return "register.jsp";   
	}
	@RequestMapping(path="add_emp",method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("emp") Employee emp) {
		edao.saveEmployee(emp);
		return "redirect:/viewemp.jsp";
	}
	@RequestMapping("/viewemp")    
    public String viewemp(Model m){    
        List<Employee> list=edao.getDetails();    
        m.addAttribute("list",list);  
        return "viewemp.jsp";    
    }    
	@RequestMapping(value="/editemp/{empid}")    
    public String edit(@PathVariable int empid, Model m){
        List<Employee> e=edao.seletedEmploye(empid);
        m.addAttribute("command",e);  
        return "update.jsp";    
    }  
	@RequestMapping(value="/editsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("emp") Employee emp){    
        edao.updateEmploye(emp);    
        return "redirect:/viewemp.jsp";    
    }    
    /* It deletes record for the given id in URL and redirects to /viewemp */    
    @RequestMapping(value="/deleteemp/{empid}",method = RequestMethod.GET)    
    public String delete(@PathVariable int empid){    
        edao.deleteEmploye(empid);    
        return "redirect:/viewemp.jsp";    
    }     

}
