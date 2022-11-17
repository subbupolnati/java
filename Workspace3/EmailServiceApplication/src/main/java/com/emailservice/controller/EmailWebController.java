package com.emailservice.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emailservice.model.EmailDetails;
import com.emailservice.service.EmailService;
@Controller
public class EmailWebController {
	@Autowired
	private EmailService emailService;
	
	@RequestMapping("/home")
	public String home(Model m) {
		m.addAttribute("email",new EmailDetails());
		return "mail";
	}
	@RequestMapping("/sendMail")
    public String sendMail(@ModelAttribute("email") EmailDetails email,Model m)
    {
        String status= emailService.sendMail(email);
        m.addAttribute("msg",status);
        //return "redirect:home";
        return "mail";
    }
    @RequestMapping("/sendMailWithAttachment")
    public String sendMailWithAttachment(@ModelAttribute("email")EmailDetails email,Model m) throws MessagingException
    {
    	String status= emailService.sendMailWithAttachment(email);
        m.addAttribute("msg",status);
        return "mail";
    }
}
