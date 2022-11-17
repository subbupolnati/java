package com.emailservice.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.emailservice.exception.EmailNotSentException;
import com.emailservice.model.EmailDetails;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	 @Value("${spring.mail.username}") 
	 private String sender;
	 
	 public String sendMail(EmailDetails email) {
		 try {
			 SimpleMailMessage message=new SimpleMailMessage();
			 message.setFrom(sender);
			 message.setTo(email.getTo());
			 message.setSubject(email.getSubject());
			 message.setText(email.getMsgBody());
			 javaMailSender.send(message);
			 System.out.println(message);
			 return "Email sent successfully";
		 }catch(EmailNotSentException  e) {
			 return "Email not Sent";
		 }
	 }
	 public String sendMailWithAttachment(EmailDetails email) throws MessagingException {
		 MimeMessage mimeMessage=javaMailSender.createMimeMessage();
		 MimeMessageHelper mimeMessageHelper;
		 try {
			 mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
			 mimeMessageHelper.setFrom(sender);
			 mimeMessageHelper.setTo(email.getTo());
			 mimeMessageHelper.setText(email.getMsgBody(),"\"text/html; charset=utf-8\"");
			 mimeMessageHelper.setSubject(email.getSubject());
			 FileSystemResource file=new FileSystemResource(new File(email.getAttachment()));
			 System.out.println(file);
			 mimeMessageHelper.addAttachment(file.getFilename(), file);
		     javaMailSender.send(mimeMessage);
		     return "Mail sent Successfully";
		 }
		 catch (EmailNotSentException e) {
		          return "Error while sending mail!!!";
		 }
	 }
}
