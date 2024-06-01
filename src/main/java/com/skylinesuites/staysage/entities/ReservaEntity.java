package com.skylinesuites.staysage.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "reservas")
public class ReservaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombreCliente;
    private String apellido;
    private String email;
    private String telefono;
    private String fechaEntrada;
    private String fechaSalida; // Añadido el campo fechaSalida
    private int cantidadPersonas;

    public ReservaEntity() {
    }

    public ReservaEntity(long id, String nombreCliente, String apellido, String email, String telefono, String fechaEntrada, String fechaSalida, int cantidadPersonas) {
        this.id = id;
        this.nombreCliente = nombreCliente;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.cantidadPersonas = cantidadPersonas;
    }

    // Getters y Setters
    // ...

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public long getId() {
        return id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }
}
