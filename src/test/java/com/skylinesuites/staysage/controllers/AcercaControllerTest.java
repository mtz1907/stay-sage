package com.skylinesuites.staysage.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

class AcercaControllerTest {

    @InjectMocks
    AcercaController acercaController;

    @Mock
    Model model;

    @SuppressWarnings("deprecation")
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void catalogo() {
        String result = acercaController.catalogo(model);
        assertEquals("pages/acerca", result);
        verify(model).addAttribute("pagina", "acerca");
    }
}
