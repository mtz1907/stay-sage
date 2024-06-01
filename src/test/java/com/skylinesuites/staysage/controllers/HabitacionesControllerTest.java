package com.skylinesuites.staysage.controllers;

import com.skylinesuites.staysage.entities.HabitacionEntity;
import com.skylinesuites.staysage.services.HabitacionService;
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

class HabitacionesControllerTest {

    @InjectMocks
    HabitacionesController habitacionesController;

    @Mock
    HabitacionService habitacionService;

    @Mock
    Model model;

    @SuppressWarnings("deprecation")
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void habitaciones() {
        List<HabitacionEntity> habitaciones = new ArrayList<>();
        when(habitacionService.listarHabitaciones()).thenReturn(habitaciones);

        String result = habitacionesController.habitaciones(model);

        assertEquals("pages/habitaciones", result);
        verify(model).addAttribute("habitaciones", habitaciones);
        verify(model).addAttribute("habitacion", new HabitacionEntity());
    }

    @Test
    void totalHabitaciones() {
        List<HabitacionEntity> habitaciones = new ArrayList<>();
        when(habitacionService.listarHabitaciones()).thenReturn(habitaciones);

        String result = habitacionesController.totalHabitaciones(model);

        assertEquals("pages/total-habitaciones", result);
        verify(model).addAttribute("habitaciones", habitaciones);
    }

    // Add more test methods for other controller methods if needed
}
