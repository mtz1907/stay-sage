package com.skylinesuites.staysage.repositories;

import com.skylinesuites.staysage.entities.CheckInEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckInRepository extends JpaRepository<CheckInEntity, Long> {
}
