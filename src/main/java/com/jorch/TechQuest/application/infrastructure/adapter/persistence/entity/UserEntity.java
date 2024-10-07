package com.jorch.TechQuest.application.infrastructure.adapter.persistence.entity;

import com.jorch.TechQuest.domain.model.Role;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(nullable = false)
    private boolean active = true;

    // Constructor con parámetros
    public UserEntity(String email, String password, Role role, boolean active) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.active = active;
    }
}
