package com.skylinesuites.staysage.controllers;

import com.skylinesuites.staysage.entities.ReservaEntity;
import com.skylinesuites.staysage.services.impl.ReservaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ReservasController {

    @Autowired
    private ReservaServiceImpl reservaService;

    @GetMapping("/reservas")
    public String reservas(@RequestParam(value = "nombreReserva", required = false) String nombreReserva, Model model) {
        List<ReservaEntity> reservas = null;
        if (nombreReserva != null && !nombreReserva.isEmpty()) {
            reservas = reservaService.buscarReservas(nombreReserva);
        }
        List<ReservaEntity> ultimasReservas = reservaService.listarReserva();
        if (ultimasReservas.size() > 10) {
            ultimasReservas = ultimasReservas.subList(ultimasReservas.size() - 10, ultimasReservas.size());
        }
        model.addAttribute("pagina", "reservas");
        model.addAttribute("reservasBusqueda", reservas);
        model.addAttribute("reservas", ultimasReservas);
        model.addAttribute("reserva", new ReservaEntity());
        return "pages/reservas";
    }

    @PostMapping("/reservas")
    public String reservasPost(@ModelAttribute ReservaEntity reserva) {
        reservaService.reservar(reserva);
        return "redirect:/reservas";
    }

    @GetMapping("/reservas/total-reservaciones")
    public String totalReservaciones(Model model) {
        model.addAttribute("totalReservaciones", reservaService.listarReserva());
        return "pages/total-reservas";
    }

    @GetMapping("/reservas/total-reservaciones/editar/{id}")
    public String editarReservacion(@PathVariable("id") long id, Model model) {
        model.addAttribute("reservacion", reservaService.buscarReserva(id));
        return "pages/editar-reserva";
    }

    @PostMapping("/reservas/total-reservaciones/editar/{id}")
    public String editarReservacion(@PathVariable("id") long id,
                                    @ModelAttribute ReservaEntity reserva) {
        ReservaEntity reservaActual = reservaService.buscarReserva(id);
        reservaActual.setId(reserva.getId());
        reservaActual.setNombreCliente(reserva.getNombreCliente());
        reservaActual.setApellido(reserva.getApellido());
        reservaActual.setEmail(reserva.getEmail());
        reservaActual.setTelefono(reserva.getTelefono());
        reservaActual.setFechaEntrada(reserva.getFechaEntrada());
        reservaActual.setFechaSalida(reserva.getFechaSalida()); // Añadido para fechaSalida
        reservaActual.setCantidadPersonas(reserva.getCantidadPersonas());
        reservaService.reservar(reservaActual);
        return "redirect:/reservas/total-reservaciones";
    }

    @GetMapping("/reservas/total-reservaciones/eliminar/{id}")
    public String eliminaeservacion(@PathVariable("id") long id, Model model) {
        model.addAttribute("reservacion", reservaService.buscarReserva(id));
        reservaService.eliminarReserva(id);
        return "redirect:/reservas/total-reservaciones";
    }

    @PostMapping("/reservas/total-reservaciones/eliminar/{id}")
    public String eliminarReservacion(@PathVariable("id") long id, @ModelAttribute ReservaEntity reserva) {
        reservaService.eliminarReserva(reserva.getId());
        return "redirect:/reservas/total-reservaciones";
    }
}
