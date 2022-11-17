package com.emailservice.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emailservice.model.EmailDetails;
import com.emailservice.service.EmailService;

//@RestController
public class EmailController {

	@Autowired
	private EmailService emailService;
	@PostMapping("/sendMail")
    public String sendMail(@RequestBody EmailDetails email)
    {
        return emailService.sendMail(email);
    }
    @PostMapping("/sendMailWithAttachment")
    public String sendMailWithAttachment(@RequestBody EmailDetails email) throws MessagingException
    {
    	return emailService.sendMailWithAttachment(email);
    }
}
