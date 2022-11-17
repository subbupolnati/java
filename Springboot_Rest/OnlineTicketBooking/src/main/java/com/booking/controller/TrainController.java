package com.booking.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.booking.model.Buses;
import com.booking.model.Trains;
import com.booking.service.TrainService;

@Controller
public class TrainController {

	@Autowired
	TrainService trainService;
	
	@RequestMapping("/trainpage")
	public String trainpage(Model m){
		Trains train=new Trains();
		m.addAttribute("train",train);
		return "trainBooking";
	}
	@RequestMapping("/addTrain")
	public String addNewFlight(Model m) {
		Trains train=new Trains();
		m.addAttribute("train",train);
		return "trainRegister";
	}
	@RequestMapping("/saveTrain")
	public String inserTrain(@ModelAttribute("train") Trains train) throws IOException {
        Trains t = trainService.insertTrain(train);
		return "redirect:trainhome";
	}
	@RequestMapping("/trainhome")
	public String trainHome(Model m) {
		List<Trains> train=trainService.getTrain();
		m.addAttribute("train",train);
		return "viewAllTrains";
	}
	@RequestMapping("/updatetrain/{trainNo}")
	public String updateTrain(@PathVariable(value = "trainNo")int trainNo, Model m) {
		Trains t=trainService.updateTrain(trainNo);
        m.addAttribute("train", t);
        return "updateTrain";
    }
	
	@RequestMapping("/deletetrain/{trainNo}")
	public String deleteTrain(@PathVariable(value="trainNo")int trainNo)
	{
		trainService.deleteTrain(trainNo);
		return "redirect:trainhome";
	}
	@RequestMapping("/train/booking")
	public String bookingTrain(@ModelAttribute("train") Trains train,Model m) {
		List<Trains> t=trainService.searchTrains(train.getTo(),train.getFrom());
		m.addAttribute("train",t);
		return "viewTrains.html";
	}
}
