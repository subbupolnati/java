package com.aadhar.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.aadhar.model.Aadhar;
import com.aadhar.service.AadharService;



@Controller
public class AadharController {

	@Autowired
	private AadharService aadharService;

	public AadharService getAadharService() {
		return aadharService;
	}

	public void setAadharService(AadharService aadharService) {
		this.aadharService = aadharService;
	}
	
	@RequestMapping("/newaadhar")
	public String createNewAadhar(Model m) {
		Aadhar aadhar=new Aadhar();
		m.addAttribute("aadhar",aadhar);
		return "register.html";
	}
	
	@PostMapping("/save")
	public String createAadhar(@ModelAttribute("aadhar") Aadhar aadhar, Model model,final @RequestParam("imagefile") MultipartFile file) throws IOException {
		 byte[] byteObjects = file.getBytes();//convertToBytes(file);
		 String encodedString = Base64.getEncoder().encodeToString(byteObjects);
		 aadhar.setImage(encodedString);
		 aadharService.createAadhar(aadhar);
		 return "redirect:aadhar";
	}

	/*
	 * private byte[] convertToBytes(MultipartFile file) throws IOException { byte[]
	 * byteObjects = new byte[file.getBytes().length]; int i = 0; for (byte b :
	 * file.getBytes()) { byteObjects[i++] = b; } return byteObjects; }
	 */
	@GetMapping("/aadhar")
	public String getAllDetails(Model m){
		
		List<Aadhar> aadhar=aadharService.getAllDetails();
		m.addAttribute("aadhar",aadhar);
		return "view";
	}
	@RequestMapping("/update/{aadharNumber}")
	public String updateAadhar(@PathVariable("aadharNumber") String aadharNumber,Model m) {
		Aadhar e=aadharService.update(aadharNumber);
		m.addAttribute("aadhar", e);
		return "update";
	}
	@RequestMapping("/delete/{aadharNumber}")
	public String deleteAadhar(@PathVariable("aadharNumber") String aadharNumber){
		aadharService.delete(aadharNumber);
		return "view";
	}
	/*
	 * @RequestMapping(value="/save",method = RequestMethod.POST, consumes =
	 * {"multipart/form-data"}) public String insertAadhar(@ModelAttribute("aadhar")
	 * Aadhar aadhar ,@RequestParam("image") MultipartFile multipartFile) throws
	 * IOException { String fileName =
	 * StringUtils.cleanPath(multipartFile.getOriginalFilename());
	 * aadhar.setImage(fileName); Aadhar ad=aadharService.createAadhar(aadhar);
	 * String uploadDir = "user-photos/" +ad.getAadharNumber();
	 * 
	 * FileUploadUtil.saveFile(uploadDir, fileName, multipartFile); return
	 * "register"; }
	 */
}
