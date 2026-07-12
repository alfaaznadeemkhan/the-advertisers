package com.theadvertisers.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/admin")
public class DashboardController {


    @GetMapping("/dashboard")
    public String dashboard(Model model){

        model.addAttribute("totalServices",0);
        model.addAttribute("totalPortfolio",0);
        model.addAttribute("totalBlogs",0);
        model.addAttribute("totalEnquiries",0);
        model.addAttribute("activeMenu","dashboard");

        return "admin/dashboard";
    }

}
