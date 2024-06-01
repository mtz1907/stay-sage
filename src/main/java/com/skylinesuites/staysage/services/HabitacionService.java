package com.skylinesuites.staysage.services;

import com.skylinesuites.staysage.entities.HabitacionEntity;

import java.util.List;

public interface HabitacionService {
    List<HabitacionEntity> listarHabitaciones();
    void agregarHabitacion(HabitacionEntity habitacion);
    void eliminarHabitacion(long id);
    void actualizarHabitacion(HabitacionEntity habitacion);
    HabitacionEntity buscarHabitacion(long id);
}
