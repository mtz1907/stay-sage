package com.skylinesuites.staysage.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServiciosController {

    @GetMapping("/servicios")
    public String catalogo(Model model) {
        model.addAttribute("pagina", "servicios");
        return "pages/servicios";
    }
}
