package com.booking.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.booking.model.Buses;
import com.booking.model.User;
import com.booking.service.BusService;
import com.booking.service.UserService;


@Controller
public class BusController {

	
	@Autowired
	BusService busService;
	
	@RequestMapping("/buspage")
	public String buspage(Model m){
		Buses bus=new Buses();
		m.addAttribute("bus", bus);
		return "busBooking";
	}
	@RequestMapping("/addbus")
	public String addNewBus(Model model) {
        Buses bus= new Buses();
        model.addAttribute("bus",bus);
        return "busregister";
    }
	@RequestMapping("/bushome")
	public String home(Model m) {
		List<Buses> bus=busService.getBus();
		m.addAttribute("bus", bus);
		return "viewAllBuses";
	}
	@RequestMapping("/savebus")
	public String inserBus(@ModelAttribute("bus") Buses bus) throws IOException {
        Buses b= busService.insertBus(bus);
		return "redirect:bushome";
	}
	@RequestMapping("/update/{busId}")
	public String updateBus(@PathVariable(value = "busId")int busId, Model m) {
		Buses b=busService.update(busId);
        m.addAttribute("bus", b);
        return "updateBus";
    }
	
	@RequestMapping("/delete/{busId}")
	public String deleteBus(@PathVariable(value="busId")int busId)
	{
		busService.delete(busId);
		return "redirect:bushome";
	}
	@RequestMapping("/bus/booking")
	public String bookingBus(@ModelAttribute("bus") Buses bus,Model m) {
		List<Buses> b=busService.searchBuses(bus.getTo(),bus.getFrom());
		System.out.println(""+b);
		m.addAttribute("bus",b);
		return "viewBuses.html";
	}
	
	@RequestMapping("/viewbuses")
	public String viewAll() {
		List<Buses> bus=busService.getBus();
		return "viewBuses";
	}
	@RequestMapping("/success")
	public String successpage() {
		return "success";
	}
}
