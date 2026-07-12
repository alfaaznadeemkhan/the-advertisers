package com.theadvertisers.controller.admin;

import com.theadvertisers.entity.ContactMessage;
import com.theadvertisers.service.TheAdvertisersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminEnquiryController {

    @Autowired
    private TheAdvertisersService theAdvertisersService;

    @GetMapping("/enquiries")
    public String enquiries(Model model){

        List<ContactMessage> list =
                theAdvertisersService.fetchContactDetails();

        model.addAttribute("contactMessages", list);

        model.addAttribute("activeMenu","enquiries");

        model.addAttribute("pageTitle","Customer Enquiries");

        model.addAttribute("pageSubtitle",
                "Manage all customer enquiries");

        return "admin/enquiries";

    }

    @GetMapping("/enquiries/delete/{id}")
    public String delete(@PathVariable Long id){

        theAdvertisersService.deleteContactMessage(id);

        return "redirect:/admin/enquiries";

    }

}