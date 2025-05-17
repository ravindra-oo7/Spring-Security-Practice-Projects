package com.lerner.securitylearnersec01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
	
	@GetMapping("/myContact")
	public String saveContactInquiryDetails() {
		return "Contact details";
	}

}
