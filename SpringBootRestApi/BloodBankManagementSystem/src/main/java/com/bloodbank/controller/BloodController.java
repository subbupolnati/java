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

import com.bloodbank.exception.BloodNotFoundException;
import com.bloodbank.model.Blood;
import com.bloodbank.model.Donor;
import com.bloodbank.model.Permission;
import com.bloodbank.service.BloodService;
import com.bloodbank.service.DonorService;
import com.bloodbank.service.PermissionService;

@Controller
public class BloodController {

	@Autowired
	private BloodService bloodService;
	@Autowired
	private DonorService donorService;
	@Autowired
	private PermissionService permissionService;
	Logger logger=LoggerFactory.getLogger("BloodController.class");
	@RequestMapping("/newblood")
	public String createBlood(Model m) {
		m.addAttribute("blood",new Blood());
		List<Permission> plist=permissionService.getAllPermissions();
		List<Donor> donorList=donorService.getALLDonors();
		m.addAttribute("donorList", donorList);
		m.addAttribute("permissionList", plist);
		return "BloodRegister";
	}
	@PostMapping("/saveblood")
	public String saveBlood(@ModelAttribute("blood")Blood blood,Model m) {
		logger.info("blood register successfully");
		bloodService.addBlood(blood);
		m.addAttribute("msg","blood added successfully");
		return "redirect:newblood";
	}
	@RequestMapping("/viewbloods")
	public String viewBloods(Model m) {
		logger.info("view All blood details ");
		List<Blood> bloodList=bloodService.getAllBlood();
		m.addAttribute("bloodList", bloodList);
		return "viewBloods";
	}
	@RequestMapping("/updateblood/{id}")
	public String updateBlood(@PathVariable("id")int id,Model m) {
		logger.info("blood details upadted based on blood id");
		List<Permission> plist=permissionService.getAllPermissions();
		List<Donor> donorList=donorService.getALLDonors();
		m.addAttribute("blood",bloodService.updateBlood(id));
		m.addAttribute("donorList", donorList);
		m.addAttribute("permissionList", plist);
		m.addAttribute("msg","successfully updated");
		return "BloodRegister";
	}
	@RequestMapping("/deleteblood/{id}")
	public String deleteBlood(@PathVariable("id") int id,Model m) {
		logger.error("no data found");
		bloodService.deleteBlood(id);
		List<Blood> bloodList=bloodService.getAllBlood();
		m.addAttribute("bloodList", bloodList);
		return "viewBloods";
	}
	@RequestMapping("/searchblood")
	public String searchDonor(@RequestParam("id") String id,Model m) {
		List<Blood> bloodList=bloodService.searchBlood(id);
		if(bloodList.isEmpty()) {
			m.addAttribute("message","No data Found");
			return "viewBloods";
		}
		m.addAttribute("bloodList", bloodList);
		return "viewBloods";
	}
}
