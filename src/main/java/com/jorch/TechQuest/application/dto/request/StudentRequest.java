package com.jorch.TechQuest.application.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StudentRequest {

    @NotBlank(message = "El nombre es obligatorio.")
    private String name;

    @NotBlank(message = "El email es obligatorio.")
    @Email(message = "El formato del email no es válido.")
    private String email;

    @NotNull(message = "La contraseña es obligatoria.")
    private String password; // Puedes usar @NotBlank si deseas permitir que no sea nulo

    private boolean active = true; // Asignar un valor predeterminado
}
