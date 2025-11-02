package com.theadvertisers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/the-advertisers")
public class PageController {


    @GetMapping(path = "/")
    public String home(){

        return "home";

    }

    @GetMapping(path = "/services")
    public String services(){

        return "services";
    }

    @GetMapping(path = "/about")
    public String about(){
        return "about";
    }

    @GetMapping(path = "/contact")
    public String contact(){

        return "contact";
    }

    @GetMapping(path = "/portfolio")
    public String portfolio(){

        return "portfolio";
    }


}
