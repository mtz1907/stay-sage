package com.skylinesuites.staysage.controllers;

import com.skylinesuites.staysage.entities.EmpleadoEntity;
import com.skylinesuites.staysage.repositories.EmpleadoRepository;
//import com.skylinesuites.staysage.security.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class WebController {

    //@Autowired
    //private JwtUtil jwtUtil;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @GetMapping("/")
    public String index() {
        return "pages/index";
    }

    @GetMapping("/ingresar")
    public String login() {
        return "pages/ingresar";
    }

    @PostMapping("/ingresar")
    public String loginPost(@RequestParam("usuario") String usuario, @RequestParam("contraseña") String contrasena, RedirectAttributes redirectAttributes) {
        EmpleadoEntity empleadoEntity = empleadoRepository.findByNombreEmpleado(usuario);
        if (empleadoEntity != null && empleadoEntity.getContraseña().equals(contrasena)) {
            com.skylinesuites.staysage.another.InformacionAdicional.nombreUsuario = usuario;
            com.skylinesuites.staysage.another.InformacionAdicional.inicioSesion = true;
            return "redirect:/inicio";
        }
        redirectAttributes.addFlashAttribute("error", "Usuario o contraseña incorrectos");
        return "redirect:/ingresar?error";
    }

}
