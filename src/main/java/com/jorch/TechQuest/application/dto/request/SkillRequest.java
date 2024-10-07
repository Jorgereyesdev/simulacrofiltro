package com.jorch.TechQuest.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SkillRequest {

    @NotBlank(message = "El nombre de la habilidad es obligatorio.")
    private String name;

    @NotBlank(message = "La descripción de la habilidad es obligatoria.")
    private String description;
}
