package com.jorch.TechQuest.application.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EvaluateMissionRequest {

    @NotNull(message = "El ID del estudiante es obligatorio.")
    private Long studentId; // ID del estudiante

    @NotNull(message = "Los comentarios son obligatorios.")
    private String comments; // Comentarios sobre la evaluación

    @NotNull(message = "La puntuación es obligatoria.")
    private int score; // Puntuación obtenida en la misión
}
