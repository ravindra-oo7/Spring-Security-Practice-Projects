package com.lerner.securitylearnersec01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	@GetMapping("/myAccount")
	public String getAccountDetails() {
        return "Account details";
    }
}
