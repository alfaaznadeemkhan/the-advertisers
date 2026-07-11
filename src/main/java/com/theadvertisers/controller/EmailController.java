package com.theadvertisers.controller;

import com.theadvertisers.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/test-email")
    public String test() {

        emailService.sendTestMail();

        return "Mail Sent Successfully";
    }
}