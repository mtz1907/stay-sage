package com.skylinesuites.staysage.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class HabitacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipoHabitacion;
    private Integer cantidad;
    private Double costo;

    public HabitacionEntity(String tipoHabitacion, Integer cantidad, Double costo) {
        this.tipoHabitacion = tipoHabitacion;
        this.cantidad = cantidad;
        this.costo = costo;
    }
}
