package com.theadvertisers.serviceImpl;

import com.theadvertisers.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendTestMail() {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("noreply@theadvertisers.in");
        message.setTo("alfaaznadeemkhan@gmail.com");
        message.setSubject("Oracle SMTP Test");
        message.setText("Oracle Email Delivery is working successfully.");

        mailSender.send(message);
    }
}
