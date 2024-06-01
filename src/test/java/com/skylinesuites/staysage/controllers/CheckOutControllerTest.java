package com.skylinesuites.staysage.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

class CheckOutControllerTest {

    @InjectMocks
    CheckOutController checkOutController;

    @Mock
    Model model;

    @SuppressWarnings("deprecation")
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void checkOut() {
        String result = checkOutController.checkOut(model);
        assertEquals("pages/check-out", result);
        verify(model).addAttribute("pagina", "check-out");
    }
}
