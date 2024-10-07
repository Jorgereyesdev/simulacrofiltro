package com.jorch.TechQuest.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MissionRequest {

    @NotBlank(message = "El título de la misión es obligatorio.")
    private String title;

    @NotBlank(message = "La descripción de la misión es obligatoria.")
    private String description;
}
