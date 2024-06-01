package com.skylinesuites.staysage;

import com.skylinesuites.staysage.entities.EmpleadoEntity;
import com.skylinesuites.staysage.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.context.annotation.Bean;


@SpringBootApplication(exclude = {SecurityFilterAutoConfiguration.class})
public class StaySageApplication {
    @Autowired
    EmpleadoRepository empleadoRepository;

    public static void main(String[] args) {
        SpringApplication.run(StaySageApplication.class, args);
    }

    // Agregamos el command line runner para que se ejecute al iniciar la aplicación
    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            EmpleadoEntity empleado = new EmpleadoEntity();
            empleado.setId(1L);
            empleado.setContraseña("12345");
            empleado.setNombreEmpleado("Admin");
            empleado.setApellido("Mateo");
            empleado.setEdad(19);
            empleado.setTelefono("3146047690");
            empleado.setFechaNacimiento("19/07/2004");
            empleadoRepository.save(empleado);
        };
    }
}
