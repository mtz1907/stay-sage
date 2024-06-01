package com.skylinesuites.staysage.services;

import com.skylinesuites.staysage.entities.ReservaEntity;

import java.util.List;

public interface ReservaService {
    public void reservar(ReservaEntity reserva);

    public List<ReservaEntity> listarReserva();

    public List<ReservaEntity> buscarReservas(String nombreCliente);
    public void eliminarReserva(long id);
    public ReservaEntity buscarReserva(long id);
}
