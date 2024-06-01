package com.skylinesuites.staysage.controllers;

import com.skylinesuites.staysage.entities.EmpleadoEntity;
import com.skylinesuites.staysage.repositories.EmpleadoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class WebControllerTest {

    @InjectMocks
    WebController webController;

    @Mock
    EmpleadoRepository empleadoRepository;

    @Mock
    RedirectAttributes redirectAttributes;

    @SuppressWarnings("deprecation")
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void loginPost_ValidCredentials() {
        String usuario = "usuario";
        String contraseña = "contraseña";
        EmpleadoEntity empleadoEntity = new EmpleadoEntity();
        empleadoEntity.setNombreEmpleado(usuario);
        empleadoEntity.setContraseña(contraseña);
        when(empleadoRepository.findByNombreEmpleado(usuario)).thenReturn(empleadoEntity);

        String result = webController.loginPost(usuario, contraseña, redirectAttributes);

        assertEquals("redirect:/inicio", result);
        assertEquals(true, com.skylinesuites.staysage.another.InformacionAdicional.inicioSesion);
        assertEquals(usuario, com.skylinesuites.staysage.another.InformacionAdicional.nombreUsuario);
        verify(redirectAttributes, never()).addFlashAttribute("error", "Usuario o contraseña incorrectos");
    }

    @Test
    void loginPost_InvalidCredentials() {
        String usuario = "usuario";
        String contraseña = "contraseña";
        when(empleadoRepository.findByNombreEmpleado(usuario)).thenReturn(null);

        String result = webController.loginPost(usuario, contraseña, redirectAttributes);

        assertEquals("redirect:/ingresar?error", result);
        verify(redirectAttributes).addFlashAttribute("error", "Usuario o contraseña incorrectos");
    }
}
