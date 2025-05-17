package com.lerner.securitylearnersec01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesController {

	@GetMapping("/notices")
	public String getNoticesDetails() {
		return "Notices details";
	}
}
