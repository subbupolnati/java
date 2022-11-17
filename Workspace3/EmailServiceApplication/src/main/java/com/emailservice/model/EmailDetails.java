package com.emailservice.model;
import javax.validation.constraints.*;
public class EmailDetails {
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",flags = Pattern.Flag.CASE_INSENSITIVE)
	private String to;
	private String subject;
    private String msgBody;
    private String attachment;
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMsgBody() {
		return msgBody;
	}
	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	@Override
	public String toString() {
		return "Email [to=" + to + ", subject=" + subject + ", msgBody=" + msgBody + ", attachment=" + attachment + "]";
	}
	public EmailDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmailDetails(String to, String subject, String msgBody, String attachment) {
		super();
		this.to = to;
		this.subject = subject;
		this.msgBody = msgBody;
		this.attachment = attachment;
	}
    
}
