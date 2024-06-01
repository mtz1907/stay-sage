package com.skylinesuites.staysage.repositories;

import com.skylinesuites.staysage.entities.EmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, Long> {
    EmpleadoEntity findByNombreEmpleado(String nombreEmpleado);

    EmpleadoEntity findByTelefono(String telefono);
}
