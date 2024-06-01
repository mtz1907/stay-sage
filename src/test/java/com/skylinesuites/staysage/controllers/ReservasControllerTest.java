package com.skylinesuites.staysage.controllers;

import com.skylinesuites.staysage.entities.ReservaEntity;
import com.skylinesuites.staysage.services.impl.ReservaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ReservasControllerTest {

    @InjectMocks
    ReservasController reservasController;

    @Mock
    ReservaServiceImpl reservaService;

    @Mock
    Model model;

    @SuppressWarnings("deprecation")
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void reservas() {
        List<ReservaEntity> ultimasReservas = new ArrayList<>();
        when(reservaService.listarReserva()).thenReturn(ultimasReservas);

        String result = reservasController.reservas(null, model);

        assertEquals("pages/reservas", result);
        verify(model).addAttribute("pagina", "reservas");
        verify(model).addAttribute("reservasBusqueda", null);
        verify(model).addAttribute("reservas", ultimasReservas);
        verify(model).addAttribute("reserva", new ReservaEntity());
    }

    @Test
    void totalReservaciones() {
        List<ReservaEntity> totalReservaciones = new ArrayList<>();
        when(reservaService.listarReserva()).thenReturn(totalReservaciones);

        String result = reservasController.totalReservaciones(model);

        assertEquals("pages/total-reservas", result);
        verify(model).addAttribute("totalReservaciones", totalReservaciones);
    }

    // Add more test methods for other controller methods if needed
}
