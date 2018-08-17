package com.mdtsoft.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptEncoder {
	public static void main(String[] args) {
		String encoded1 = new BCryptPasswordEncoder().encode("123.");
		String encoded2 = new BCryptPasswordEncoder().encode("111.");
		String encoded3 = new BCryptPasswordEncoder().encode("000.");
		
		System.out.println("{bcrypt}" + encoded1);
		System.out.println("{bcrypt}" + encoded2);
		System.out.println("{bcrypt}" + encoded3);
	}
}
