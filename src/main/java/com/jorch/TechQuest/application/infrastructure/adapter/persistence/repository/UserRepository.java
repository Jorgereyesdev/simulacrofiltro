package com.jorch.TechQuest.application.infrastructure.adapter.persistence.repository;

import com.jorch.TechQuest.application.infrastructure.adapter.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email); // Método para encontrar un usuario por su email
}
