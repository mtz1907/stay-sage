package com.skylinesuites.staysage.controllers;

import com.skylinesuites.staysage.entities.ArticulosEntity;
import com.skylinesuites.staysage.services.ArticuloService;
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

class ArticuloControllerTest {

    @InjectMocks
    ArticuloController articuloController;

    @Mock
    ArticuloService articuloService;

    @Mock
    Model model;

    @SuppressWarnings("deprecation")
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void articulos() {
        List<ArticulosEntity> articulos = new ArrayList<>();
        when(articuloService.listarArticulos()).thenReturn(articulos);

        String result = articuloController.articulos(model);

        assertEquals("pages/articulos", result);
        verify(model).addAttribute("pagina", "articulos");
        verify(model).addAttribute("articulos", articulos);
    }

    @Test
    void verTodos() {
        List<ArticulosEntity> articulos = new ArrayList<>();
        when(articuloService.listarArticulos()).thenReturn(articulos);

        String result = articuloController.verTodos(model);

        assertEquals("pages/total-articulos", result);
        verify(model).addAttribute("articulos", articulos);
    }

    // Add more test methods for other controller methods if needed
}
