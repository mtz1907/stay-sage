package com.skylinesuites.staysage.controllers;

import com.skylinesuites.staysage.entities.HabitacionEntity;
import com.skylinesuites.staysage.services.HabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HabitacionesController {

    @Autowired
    HabitacionService habitacionService;

    @GetMapping("/habitaciones")
    public String habitaciones(Model model) {
        model.addAttribute("habitaciones", habitacionService.listarHabitaciones());
        model.addAttribute("habitacion", new HabitacionEntity());
        return "pages/habitaciones";
    }
    

    @PostMapping("/habitaciones/agregar")
    public String agregarHabitacion(@ModelAttribute HabitacionEntity habitacion) {
        habitacionService.agregarHabitacion(habitacion);
        return "redirect:/habitaciones";
    }

    @GetMapping("/habitaciones/total-habitaciones")
    public String totalHabitaciones(Model model) {
        model.addAttribute("habitaciones", habitacionService.listarHabitaciones());
        return "pages/total-habitaciones";
    }

    @GetMapping("/habitaciones/total-habitaciones/editar/{id}")
    public String editarHabitacion(@PathVariable Long id, Model model) {
        HabitacionEntity habitacion = habitacionService.buscarHabitacion(id);
        model.addAttribute("habitacion", habitacion);
        return "pages/editar-habitacion";
    }

    @PostMapping("/habitaciones/total-habitaciones/editar/{id}")
    public String actualizarHabitacion(@PathVariable Long id, @ModelAttribute HabitacionEntity habitacion) {
        HabitacionEntity habitacionExistente = habitacionService.buscarHabitacion(id);
        if (habitacionExistente != null) {
            habitacionExistente.setTipoHabitacion(habitacion.getTipoHabitacion());
            habitacionExistente.setCantidad(habitacion.getCantidad());
            habitacionExistente.setCosto(habitacion.getCosto());
            habitacionService.actualizarHabitacion(habitacionExistente);
        }
        return "redirect:/habitaciones/total-habitaciones";
    }

    @GetMapping("/habitaciones/total-habitaciones/eliminar/{id}")
    public String eliminarHabitacion(@PathVariable Long id) {
        habitacionService.eliminarHabitacion(id);
        return "redirect:/habitaciones/total-habitaciones";
    }
}
