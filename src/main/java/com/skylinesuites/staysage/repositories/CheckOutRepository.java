package com.skylinesuites.staysage.repositories;

import com.skylinesuites.staysage.entities.CheckOutEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckOutRepository extends JpaRepository<CheckOutEntity, Long> {
}
