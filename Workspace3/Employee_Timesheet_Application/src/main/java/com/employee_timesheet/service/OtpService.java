package com.employee_timesheet.service;

import java.text.DecimalFormat;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee_timesheet.model.Otp;
import com.employee_timesheet.repository.OtpRepository;

@Service
public class OtpService {

	@Autowired
	private OtpRepository otpRepository;
	
	//In This method store otp data in database
	public Otp insertOtp(Otp otp) {
		String otp1= new DecimalFormat("000000").format(new Random().nextInt(999999));
		otp.setOtp(otp1);
		return otpRepository.save(otp);
	}
}
