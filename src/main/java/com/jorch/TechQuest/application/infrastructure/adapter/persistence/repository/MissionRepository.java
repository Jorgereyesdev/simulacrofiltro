package com.jorch.TechQuest.application.infrastructure.adapter.persistence.repository;

import com.jorch.TechQuest.application.infrastructure.adapter.persistence.entity.MissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionRepository extends JpaRepository<MissionEntity, Long> {
    // Puedes agregar métodos personalizados aquí si es necesario
}
