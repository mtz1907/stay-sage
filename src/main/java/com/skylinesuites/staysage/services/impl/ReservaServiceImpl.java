package com.skylinesuites.staysage.services.impl;

import com.skylinesuites.staysage.entities.ReservaEntity;
import com.skylinesuites.staysage.repositories.ReservaRepository;
import com.skylinesuites.staysage.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Override
    public void reservar(ReservaEntity reserva) {
        reservaRepository.save(reserva);
    }

    @Override
    public List<ReservaEntity> listarReserva() {
        return reservaRepository.findAll();
    }

    @Override
    public List<ReservaEntity> buscarReservas(String nombreCliente) {
        return reservaRepository.findAllByNombreCliente(nombreCliente);
    }

    @Override
    public void eliminarReserva(long id) {
        reservaRepository.deleteById(id);
    }

    @Override
    public ReservaEntity buscarReserva(long id) {
        return reservaRepository.findById(id).orElse(null);
    }
}
