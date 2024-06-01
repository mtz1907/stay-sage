package com.skylinesuites.staysage.services.impl;

import com.skylinesuites.staysage.entities.HabitacionEntity;
import com.skylinesuites.staysage.repositories.HabitacionesRepository;
import com.skylinesuites.staysage.services.HabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitacionServiceImpl implements HabitacionService {

    @Autowired
    HabitacionesRepository habitacionesRepository;

    @Override
    public List<HabitacionEntity> listarHabitaciones() {
        return habitacionesRepository.findAll();
    }

    @Override
    public void agregarHabitacion(HabitacionEntity habitacion) {
        habitacionesRepository.save(habitacion);
    }

    @Override
    public void eliminarHabitacion(long id) {
        habitacionesRepository.deleteById(id);
    }

    @Override
    public void actualizarHabitacion(HabitacionEntity habitacion) {
        habitacionesRepository.save(habitacion);
    }

    @Override
    public HabitacionEntity buscarHabitacion(long id) {
        return habitacionesRepository.findById(id).orElse(null);
    }
}
