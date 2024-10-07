package com.jorch.TechQuest.application.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class CreateMissionRequest {

    @NotNull(message = "El título de la misión es obligatorio.")
    private String title; // Título de la misión

    @NotNull(message = "La descripción de la misión es obligatoria.")
    private String description; // Descripción de la misión

    @NotEmpty(message = "La lista de estudiantes no puede estar vacía.")
    private List<Long> studentIds; // IDs de los estudiantes a los que se asignará la misión

    @NotEmpty(message = "La lista de habilidades requeridas no puede estar vacía.")
    private List<Long> requiredSkillIds; // Habilidades requeridas para completar la misión
}
