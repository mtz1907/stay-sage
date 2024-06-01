package com.skylinesuites.staysage.services.impl;

import com.skylinesuites.staysage.entities.EmpleadoEntity;
import com.skylinesuites.staysage.repositories.EmpleadoRepository;
import com.skylinesuites.staysage.services.EmpleadoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class EmpleadoServiceImpl implements EmpleadoService {
    @Autowired
    EmpleadoRepository empleadoRepository;
    @Override
    public List<EmpleadoEntity> listarEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public void agregarEmpleado(EmpleadoEntity empleado) {
        empleadoRepository.save(empleado);
    }

    @Override
    public void eliminarEmpleado(long id) {
        empleadoRepository.deleteById(id);
    }

    @Override
    public void actualizarEmpleado(EmpleadoEntity empleado) {
        EmpleadoEntity empleadoEntity = empleadoRepository.findById(empleado.getId()).orElse(null);
        if (Objects.nonNull(empleadoEntity)) {
            empleadoEntity.setNombreEmpleado(empleado.getNombreEmpleado());
            empleadoEntity.setApellido(empleado.getApellido());
            empleadoEntity.setEdad(empleado.getEdad());
            empleadoEntity.setTelefono(empleado.getTelefono());
            empleadoEntity.setFechaNacimiento(empleado.getFechaNacimiento());
            empleadoRepository.save(empleadoEntity);
        } else {
            log.info("No se encontró el empleado con id: {}", empleado.getId());
        }
    }

    public boolean iniciarSesion(String nombreEmpleado, String contraseña){
        EmpleadoEntity empleadoEntity = empleadoRepository.findByNombreEmpleado(nombreEmpleado);
        if(empleadoEntity != null){
            if(empleadoEntity.getContraseña().equals(contraseña)){
                return true;
            }
        }
        return false;
    }

    @Override
    public EmpleadoEntity buscarEmpleado(long id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    @Override
    public boolean telefonoExiste(String telefono) {
        EmpleadoEntity empleadoEntity = empleadoRepository.findByTelefono(telefono);
        return empleadoEntity != null;
    }
}
