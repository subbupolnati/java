package com.bloodbank.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bloodbank.model.Donor;
import com.bloodbank.model.Permission;
import com.bloodbank.service.DonorService;
import com.bloodbank.service.PermissionService;

@Controller
public class DonorController {

	@Autowired
	private DonorService donorService;
	@Autowired
	private PermissionService permissionService;
	Logger logger=LoggerFactory.getLogger("DonorController.class");
	@RequestMapping("/newdonor")
	public String createDonor(Model m) {
		m.addAttribute("donor",new Donor());
		List<Permission> plist=permissionService.getAllPermissions();
		m.addAttribute("permissionList", plist);
		return "DonorRegister";
	}
	@PostMapping("/savedonor")
	public String saveDonor(@ModelAttribute("donor") Donor donor,Model m) {
		logger.info("Donor Register Successfully");
		donorService.addDonor(donor);
		m.addAttribute("msg","donor added successfully");
		return "redirect:newdonor";
	}
	@RequestMapping("/viewdonors")
	public String viewDonors(Model m) {
		logger.info("view All donors list");
		List<Donor> donorList=donorService.getALLDonors();
		m.addAttribute("donorList", donorList);
		return "viewDonors";
	}
	@RequestMapping("/updatedonor/{id}")
	public String updateDonor(@PathVariable("id")int id,Model m) {
		logger.info("update donor list based on id");
		List<Permission> plist=permissionService.getAllPermissions();
		m.addAttribute("donor",donorService.updateDonor(id));
		m.addAttribute("permissionList", plist);
		return "DonorRegister";
	}
	@RequestMapping("/deletedonor/{id}")
	public String deleteDonor(@PathVariable("id") int id,Model m) {
		logger.info("delete donor based on id");
		donorService.deleteDonor(id);
		List<Donor> donorList=donorService.getALLDonors();
		m.addAttribute("donorList", donorList);
		return "viewDonors";
	}
	@RequestMapping("/searchdonor")
	public String searchDonor(@RequestParam("id") int id,Model m) {
		logger.info("searching donor based on id");
		List<Donor> donorList=donorService.getDonor(id);
		if(donorList.isEmpty()) {
			m.addAttribute("message","No data Found");
			return "viewDonors";
		}
		m.addAttribute("donorList", donorList);
		return "viewDonors";
	}
}
