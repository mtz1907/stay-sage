package com.skylinesuites.staysage.services.impl;

import com.skylinesuites.staysage.entities.CheckOutEntity;
import com.skylinesuites.staysage.repositories.CheckOutRepository;
import com.skylinesuites.staysage.services.CheckOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckOutServiceImpl implements CheckOutService {

    @Autowired
    private CheckOutRepository checkOutRepository;
    
    @Override
    public List<CheckOutEntity> listarCheckOut() {
        return checkOutRepository.findAll();
    }

    @Override
    public void agregarCheckOut(CheckOutEntity checkOut) {
        checkOutRepository.save(checkOut);
    }

    @Override
    public void eliminarCheckOut(long id) {
        checkOutRepository.deleteById(id);
    }

    @Override
    public void actualizarCheckOut(CheckOutEntity checkOut) {
        checkOutRepository.save(checkOut);
    }

    @Override
    public CheckOutEntity buscarCheckOut(long id) {
        return checkOutRepository.findById(id).orElse(null);
    }
}
