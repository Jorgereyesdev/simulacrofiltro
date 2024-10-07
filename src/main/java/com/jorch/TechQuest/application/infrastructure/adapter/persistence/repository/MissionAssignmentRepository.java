package com.jorch.TechQuest.application.infrastructure.adapter.persistence.repository;

import com.jorch.TechQuest.application.infrastructure.adapter.persistence.entity.MissionAssignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionAssignmentRepository extends JpaRepository<MissionAssignmentEntity, Long> {
    // Puedes agregar métodos personalizados aquí si es necesario
}
