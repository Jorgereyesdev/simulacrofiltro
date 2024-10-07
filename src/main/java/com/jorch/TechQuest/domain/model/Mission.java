package com.jorch.TechQuest.domain.model;

import com.jorch.TechQuest.shared.enums.DifficultyLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Mission {

    private Long id;
    private String description;
    private DifficultyLevel difficulty;
    private List<Skill> requiredSkills; // Cambié SkillEntity a Skill

    // Constructor con parámetros
    public Mission(String description, DifficultyLevel difficulty, List<Skill> requiredSkills) {
        this.description = description;
        this.difficulty = difficulty;
        this.requiredSkills = requiredSkills;
    }

    // Método para validar si un estudiante tiene las habilidades requeridas
    public boolean canStudentAcceptMission(List<Skill> studentSkills) {
        return studentSkills.containsAll(requiredSkills);
    }
}
