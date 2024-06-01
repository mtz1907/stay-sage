package com.skylinesuites.staysage.repositories;

import com.skylinesuites.staysage.entities.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservaRepository extends JpaRepository<ReservaEntity, Long> {
    List<ReservaEntity> findAllByNombreCliente(String nombreCliente);
    // Contamos todas las reservas que se han hecho


}
