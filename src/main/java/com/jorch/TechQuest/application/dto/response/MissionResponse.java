package com.jorch.TechQuest.application.dto.response;

import lombok.Data;
import java.util.List;

@Data
public class MissionResponse {
    private Long id; // ID de la misión
    private String title; // Título de la misión
    private String description; // Descripción de la misión
    private List<Long> assignedStudentIds; // IDs de los estudiantes asignados
    private List<Long> requiredSkillIds; // Habilidades requeridas
}
