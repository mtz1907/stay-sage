package com.skylinesuites.staysage.repositories;

import com.skylinesuites.staysage.entities.ArticulosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloRepository extends JpaRepository<ArticulosEntity, Long> {
}
