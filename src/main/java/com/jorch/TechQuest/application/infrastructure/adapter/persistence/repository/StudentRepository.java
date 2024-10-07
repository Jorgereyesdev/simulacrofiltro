package com.jorch.TechQuest.application.infrastructure.adapter.persistence.repository;

import com.jorch.TechQuest.application.infrastructure.adapter.persistence.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    // Puedes agregar métodos personalizados aquí si es necesario
}
