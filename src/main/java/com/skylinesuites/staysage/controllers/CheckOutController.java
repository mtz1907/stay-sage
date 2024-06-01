package com.skylinesuites.staysage.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CheckOutController {

    @GetMapping("/check-out")
    public String checkOut(Model model) {
        model.addAttribute("pagina", "check-out");
        return "pages/check-out";
    }
}
