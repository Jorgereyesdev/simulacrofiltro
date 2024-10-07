package com.jorch.TechQuest.application.infrastructure.adapter.persistence.entity;

import com.jorch.TechQuest.shared.enums.Status;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "mission_assignments")
@Data
public class MissionAssignmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "mission_id")
    private MissionEntity mission; // Cambiado a MissionEntity

    @Enumerated(EnumType.STRING)
    private Status status;
}
