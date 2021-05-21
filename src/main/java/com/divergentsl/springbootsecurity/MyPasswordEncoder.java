package com.divergentsl.springbootsecurity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		
		try{
			
			MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
			digest.update(rawPassword.toString().getBytes());
			byte messageDigest[] = digest.digest();
			
			StringBuffer hexString = new StringBuffer();
			for(int i=0; i<messageDigest.length; i++){
				
				hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
			}
			return hexString.toString();
			
		}catch(NoSuchAlgorithmException e){
			
			e.printStackTrace();
		}
		
		return "";
		
		
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
	
		return rawPassword.toString().equals(encodedPassword);
	}

}
