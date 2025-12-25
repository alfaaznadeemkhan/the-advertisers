package com.theadvertisers.controller;

import com.theadvertisers.entity.ContactMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/the-advertisers")
public class PageController {


    @GetMapping(path = "/")
    public String home() {

        return "home";

    }

    @GetMapping(path = "/services")
    public String services() {

        return "services";
    }

    @GetMapping(path = "/about")
    public String about() {
        return "about";
    }

    @GetMapping(path = "/contact")
    public String contact() {

        return "contact";
    }

    // Handle form submit
    @PostMapping("/contact/submit")
    public String submitContact(@ModelAttribute("contactMessage") ContactMessage contactMessage, Model model) {

        model.addAttribute("successMessage",
                "Thank you! Your message has been sent successfully.");

        // Reset form
        model.addAttribute("contactMessage", new ContactMessage());

        return "redirect:/"; // stay on same page
    }

    @GetMapping(path = "/portfolio")
    public String portfolio() {

        return "portfolio";
    }


}
