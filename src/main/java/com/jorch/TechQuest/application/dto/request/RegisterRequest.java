package com.jorch.TechQuest.application.dto.request;

import com.jorch.TechQuest.domain.model.Role;
import lombok.Data;

@Data
public class RegisterRequest {
    private String email;
    private String password;
    private Role role;
    private boolean active;
}
