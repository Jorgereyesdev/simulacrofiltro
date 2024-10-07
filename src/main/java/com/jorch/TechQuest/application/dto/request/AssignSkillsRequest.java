package com.jorch.TechQuest.application.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
public class AssignSkillsRequest {

    @NotEmpty(message = "La lista de habilidades no puede estar vacía.")
    private List<Long> skillIds; // IDs de las habilidades que se asignarán al estudiante
}
