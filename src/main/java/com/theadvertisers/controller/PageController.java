package com.theadvertisers.controller;

import com.theadvertisers.entity.ContactMessage;
import com.theadvertisers.service.TheAdvertisersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class PageController {

    @Autowired
    private TheAdvertisersService theadvertisersService;


    @GetMapping(path = "/home")
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

    // READ: Display the list
    @GetMapping(path = "/report")
    public String report(Model model) {
        List<ContactMessage> contactMessages = theadvertisersService.fetchContactDetails();
        model.addAttribute("contactMessages", contactMessages);
        return "report";
    }

    // DELETE: Handle deletion
    @GetMapping(path = "/report/delete/{id}")
    public String deleteReport(@PathVariable("id") Long id) {
        theadvertisersService.deleteContactMessage(id); // Ensure this method exists in your Service
        return "redirect:/report";
    }

}
