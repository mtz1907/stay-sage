package com.skylinesuites.staysage.services;


import com.skylinesuites.staysage.entities.CheckInEntity;

import java.util.List;

public interface CheckInService {

    public List<CheckInEntity> listarCheckIn();
    public void agregarCheckIn(CheckInEntity checkIn);
    public void eliminarCheckIn(long id);
    public void actualizarCheckIn(CheckInEntity checkIn);
    public CheckInEntity buscarCheckIn(long id);
}
