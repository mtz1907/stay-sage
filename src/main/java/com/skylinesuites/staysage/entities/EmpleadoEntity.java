package com.skylinesuites.staysage.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
public class EmpleadoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreEmpleado;
    private String contraseña;
    private String apellido;
    private int edad;
    @Column(unique = true)
    private String telefono;
    private String fechaNacimiento;

    public EmpleadoEntity(Long id, String nombre, String contraseña, String apellido, int edad, String telefono, String fechaNacimiento) {
        this.id = id;
        this.nombreEmpleado = nombre;
        this.contraseña = contraseña;
        this.apellido = apellido;
        this.edad = edad;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    public EmpleadoEntity() {
    }
}
