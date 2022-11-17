package com.booking.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.booking.model.Buses;
import com.booking.model.User;
import com.booking.service.BusService;
import com.booking.service.UserService;



@Controller
public class BusController {

	@Autowired
	UserService userService;
	@Autowired
	BusService busService;
	@RequestMapping("/")
	public String index() {
		return"index";
	}
	@RequestMapping("/loginpage")
	public String adminlogin(Model m) {
		User user=new User();
		m.addAttribute("user", user);
		return"login";
	}
	@RequestMapping("/userregister")
	public String userregister(@ModelAttribute("user") User user,Model m) {
		User u=userService.validate(user.getUsername(),user.getPassword(),user.getUsertype());
		if(u==null) {
			m.addAttribute("msg","Invalid Details");
			return "login";
			
		}
		else {
			if(user.getUsertype().equals("admin")) {
				return"homepage";
			}
			else {
				return "Userhome";
			}
		}
			
	}
	@RequestMapping("/logout")
	public String logout() {
		return "index";
	}
	@RequestMapping("/createNewUser")	
	public String newUSer(Model m) {
		User user=new User();
		m.addAttribute("user", user);
		return "userRegister";
	}
	@RequestMapping("/usersave")
	public String insertUser(@ModelAttribute("user") User user, Model m) {
		User u=userService.addNewUser(user);
		return "index";
	}
	@RequestMapping("/addnew")
	public String addNewFood(Model model) {
        Buses bus= new Buses();
        model.addAttribute("bus",bus);
        return "register";
    }
	@RequestMapping("/home")
	public String home(Model m) {
		List<Buses> bus=busService.getBus();
		m.addAttribute("bus", bus);
		return "home";
	}
	@RequestMapping("/save")
	public String inserBus(@ModelAttribute("bus") Buses bus) throws IOException {
        Buses b= busService.insertBus(bus);
		return "redirect:home";
	}
	@RequestMapping("/update/{busId}")
	public String updateBus(@PathVariable(value = "busId")int busId, Model m) {
		Buses b=busService.update(busId);
        m.addAttribute("bus", b);
        return "update";
    }
	
	@RequestMapping("/delete/{busId}")
	public String deleteBus(@PathVariable(value="busId")int busId)
	{
		busService.delete(busId);
		return "redirect:home";
	}
	/*
	 * @RequestMapping("/search") public String searchBus(@RequestParam("busname")
	 * String busname,Model m) { Bus bus=new Bus(); bus.setBunName(busname);
	 * List<Bus> b=busService.search(bus.getBunName()); m.addAttribute("bus",b);
	 * return "home"; }
	 */
}
