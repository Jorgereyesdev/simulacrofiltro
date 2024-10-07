package com.jorch.TechQuest.application.infrastructure.adapter.persistence.entity;

import com.jorch.TechQuest.shared.enums.DifficultyLevel;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "missions")
@Data
public class MissionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    private DifficultyLevel difficulty;

    @ManyToMany
    @JoinTable(
            name = "mission_skills",
            joinColumns = @JoinColumn(name = "mission_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<SkillEntity> requiredSkillEntities; // Cambiado para usar SkillEntity
}
