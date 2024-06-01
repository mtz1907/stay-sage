package com.skylinesuites.staysage.controllers;

import com.skylinesuites.staysage.entities.EmpleadoEntity;
import com.skylinesuites.staysage.services.impl.EmpleadoServiceImpl;
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

class EmpleadoControllerTest {

    @InjectMocks
    EmpleadoController empleadoController;

    @Mock
    EmpleadoServiceImpl empleadoService;

    @Mock
    Model model;

    @SuppressWarnings("deprecation")
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void empleados() {
        List<EmpleadoEntity> empleados = new ArrayList<>();
        when(empleadoService.listarEmpleados()).thenReturn(empleados);

        String result = empleadoController.empleados(model);

        assertEquals("pages/empleados", result);
        verify(model).addAttribute("empleados", empleados);
        verify(model).addAttribute("pagina", "empleados");
    }

    @Test
    void verTodosLosEmpleados() {
        List<EmpleadoEntity> empleados = new ArrayList<>();
        when(empleadoService.listarEmpleados()).thenReturn(empleados);

        String result = empleadoController.verTodosLosEmpleados(model);

        assertEquals("pages/todos-los-empleados", result);
        verify(model).addAttribute("empleados", empleados);
    }

    // Add more test methods for other controller methods if needed
}
