package com.skylinesuites.staysage.controllers;

import com.skylinesuites.staysage.services.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CheckInController {
    @SuppressWarnings("unused")
    @Autowired
    private CheckInService checkInService;

    @GetMapping("/check-in")
    public String checkIn(Model model) {
        model.addAttribute("pagina", "check-in");
        return "pages/check-in";
    }

}
