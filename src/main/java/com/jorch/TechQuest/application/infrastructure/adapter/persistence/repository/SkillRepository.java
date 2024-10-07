package com.jorch.TechQuest.application.infrastructure.adapter.persistence.repository;

import com.jorch.TechQuest.application.infrastructure.adapter.persistence.entity.SkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<SkillEntity, Long> {
    // Puedes agregar métodos personalizados aquí si es necesario
}
