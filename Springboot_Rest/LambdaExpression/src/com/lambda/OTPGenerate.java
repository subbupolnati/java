package com.lambda;

import java.util.Random;

public class OTPGenerate{
		static void getOTP() {
			String num="0123456789";
			Random r= new Random();
			char[] otp = new char[6]; 
			for(int i=0;i<6;i++) {
				otp [i]=num.charAt(r.nextInt(num.length()));
			}
			for(int i=0;i<otp.length;i++) {
				System.out.print(otp[i]);
			}
		}
		public static void main(String[] args) {
				//System.out.print("Generate OTP is : ");
				getOTP();
			}
}