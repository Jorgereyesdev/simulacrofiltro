package com.jorch.TechQuest.application.dto.request;

import lombok.Data;

@Data
public class RegisterRequest {
    private String email;
    private String password;
    private String role;
    private boolean active;
}
