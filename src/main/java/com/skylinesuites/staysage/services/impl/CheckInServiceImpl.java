package com.skylinesuites.staysage.services.impl;

import com.skylinesuites.staysage.entities.CheckInEntity;
import com.skylinesuites.staysage.repositories.CheckInRepository;
import com.skylinesuites.staysage.services.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckInServiceImpl implements CheckInService {

    @Autowired
    private CheckInRepository checkInRepository;
    @Override
    public List<CheckInEntity> listarCheckIn() {
        return checkInRepository.findAll();
    }

    @Override
    public void agregarCheckIn(CheckInEntity checkIn) {
        checkInRepository.save(checkIn);
    }

    @Override
    public void eliminarCheckIn(long id) {
        checkInRepository.deleteById(id);
    }

    @Override
    public void actualizarCheckIn(CheckInEntity checkIn) {
        checkInRepository.save(checkIn);
    }

    @Override
    public CheckInEntity buscarCheckIn(long id) {
        return checkInRepository.findById(id).orElse(null);
    }
}
