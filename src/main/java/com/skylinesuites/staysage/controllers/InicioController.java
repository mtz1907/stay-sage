package com.skylinesuites.staysage.controllers;

import com.skylinesuites.staysage.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class InicioController {

    @Autowired
    private ReservaRepository reservaRepository;


    @GetMapping("/inicio")
    public String inicio(RedirectAttributes redirectAttributes, Model model) {
        if (com.skylinesuites.staysage.another.InformacionAdicional.inicioSesion) {
            model.addAttribute("todasReservas", (!reservaRepository.findAll().isEmpty()) ? reservaRepository.findAll().size() : "No hay reservas aún");
            model.addAttribute("todosClientes", (!reservaRepository.findAll().isEmpty()) ? reservaRepository.findAll().get(0).getNombreCliente() : "No hay clientes aún");
            return "pages/inicio";
        }
        redirectAttributes.addFlashAttribute("error", "Inicia sesión para acceder a la página");
        return "redirect:/ingresar";
    }
}
