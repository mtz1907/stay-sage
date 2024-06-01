package com.skylinesuites.staysage.repositories;

import com.skylinesuites.staysage.entities.HabitacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitacionesRepository extends JpaRepository<HabitacionEntity, Long> {
}
