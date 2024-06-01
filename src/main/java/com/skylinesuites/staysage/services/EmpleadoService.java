package com.skylinesuites.staysage.services;

import com.skylinesuites.staysage.entities.EmpleadoEntity;

import java.util.List;

public interface EmpleadoService {
    List<EmpleadoEntity> listarEmpleados();
    void agregarEmpleado(EmpleadoEntity empleado);
    void eliminarEmpleado(long id);
    void actualizarEmpleado(EmpleadoEntity empleado);
    EmpleadoEntity buscarEmpleado(long id);
    boolean telefonoExiste(String telefono);
}
