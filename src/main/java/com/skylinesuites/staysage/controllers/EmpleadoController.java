package com.skylinesuites.staysage.controllers;

import com.skylinesuites.staysage.entities.EmpleadoEntity;
import com.skylinesuites.staysage.services.impl.EmpleadoServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping
public class EmpleadoController {
    @Autowired
    EmpleadoServiceImpl empleadoService;

    @GetMapping("/empleados")
    public String empleados(Model model){
        model.addAttribute("empleados", empleadoService.listarEmpleados());
        model.addAttribute("pagina", "empleados");
        return "pages/empleados";
    }

    @GetMapping("/empleados/todos-los-empleados")
    public String verTodosLosEmpleados(Model model){
        model.addAttribute("empleados", empleadoService.listarEmpleados());
        return "pages/todos-los-empleados";
    }

    @PostMapping("/empleados")
    public String empleadosPost(@ModelAttribute EmpleadoEntity empleado){
        if (empleadoService.telefonoExiste(empleado.getTelefono())){
            log.info("El telefono ya existe");
            return "redirect:/empleados?errorTelefonoExiste";
        } else {
            empleadoService.agregarEmpleado(empleado);
            return "redirect:/empleados";
        }
    }

    @GetMapping("/empleados/total-empleados/editar/{id}")
    public String editarEmpleado(@PathVariable Long id, Model model){
        model.addAttribute("empleado", empleadoService.buscarEmpleado(id));
        return "pages/editar-empleado";
    }

    @PostMapping("/empleados/total-empleados/editar/{id}")
    public String editarEmpleadoPost(@ModelAttribute EmpleadoEntity empleado){
        EmpleadoEntity empleadoActual = empleadoService.buscarEmpleado(empleado.getId());
        if (empleadoActual != null){
            empleadoActual.setId(empleado.getId());
            empleadoActual.setNombreEmpleado(empleado.getNombreEmpleado());
            empleadoActual.setApellido(empleado.getApellido());
            empleadoActual.setEdad(empleado.getEdad());
            empleadoActual.setTelefono(empleado.getTelefono());
            empleadoActual.setFechaNacimiento(empleado.getFechaNacimiento());
            empleadoService.agregarEmpleado(empleadoActual);
        } else {
            log.info("El empleado no existe");
            return "redirect:/empleados?errorEmpleadoNoExiste";
        }
        return "redirect:/empleados/todos-los-empleados";
    }

    @GetMapping("/empleados/total-empleados/eliminar/{id}")
    public String eliminarEmpleado(@PathVariable Long id){
        empleadoService.eliminarEmpleado(id);
        return "redirect:/empleados/todos-los-empleados";
    }
}

