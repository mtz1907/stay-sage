package com.skylinesuites.staysage.services;

import com.skylinesuites.staysage.entities.CheckOutEntity;

import java.util.List;

public interface CheckOutService {
    List<CheckOutEntity> listarCheckOut();
    void agregarCheckOut(CheckOutEntity checkOut);
    void eliminarCheckOut(long id);
    void actualizarCheckOut(CheckOutEntity checkOut);
    CheckOutEntity buscarCheckOut(long id);
    
}
