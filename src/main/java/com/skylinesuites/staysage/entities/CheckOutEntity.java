package com.skylinesuites.staysage.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class CheckOutEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombreCliente;
    private String apellido;
    private String email;
    private String telefono;
    private String fechaSalida; // Cambiado de fechaIngreso a fechaSalida
    private String ciudadOrigen;
    private int cantidadDiasHospedaje;
    private int cantidadAdultos;
    private int cantidadNinos;
    private String motivoViaje;
    private boolean tieneEquipaje;

    public CheckOutEntity(long id, String nombreCliente, String apellido, String email, String telefono, String fechaSalida, String ciudadOrigen, int cantidadDiasHospedaje, int cantidadAdultos, int cantidadNinos, String motivoViaje, boolean tieneEquipaje) {
        this.id = id;
        this.nombreCliente = nombreCliente;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.fechaSalida = fechaSalida;
        this.ciudadOrigen = ciudadOrigen;
        this.cantidadDiasHospedaje = cantidadDiasHospedaje;
        this.cantidadAdultos = cantidadAdultos;
        this.cantidadNinos = cantidadNinos;
        this.motivoViaje = motivoViaje;
        this.tieneEquipaje = tieneEquipaje;
    }

    public CheckOutEntity() {
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

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public void setCantidadDiasHospedaje(int cantidadDiasHospedaje) {
        this.cantidadDiasHospedaje = cantidadDiasHospedaje;
    }

    public void setCantidadAdultos(int cantidadAdultos) {
        this.cantidadAdultos = cantidadAdultos;
    }

    public void setCantidadNinos(int cantidadNinos) {
        this.cantidadNinos = cantidadNinos;
    }

    public void setMotivoViaje(String motivoViaje) {
        this.motivoViaje = motivoViaje;
    }

    public void setTieneEquipaje(boolean tieneEquipaje) {
        this.tieneEquipaje = tieneEquipaje;
    }
}
