package com.skylinesuites.staysage.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

class ServiciosControllerTest {

    @InjectMocks
    ServiciosController serviciosController;

    @Mock
    Model model;

    @SuppressWarnings("deprecation")
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void servicios() {
        String result = serviciosController.catalogo(model);
        assertEquals("pages/servicios", result);
        verify(model).addAttribute("pagina", "servicios");
    }
}
