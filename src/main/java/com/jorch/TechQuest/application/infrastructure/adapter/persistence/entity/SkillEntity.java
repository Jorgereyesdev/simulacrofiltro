package com.jorch.TechQuest.application.infrastructure.adapter.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "skills")
public class SkillEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name; // Nombre de la habilidad

    // Constructor con parámetros
    public SkillEntity(String name) {
        this.name = name;
    }
}
