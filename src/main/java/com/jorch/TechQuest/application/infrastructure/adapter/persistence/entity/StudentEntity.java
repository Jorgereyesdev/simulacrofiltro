package com.jorch.TechQuest.application.infrastructure.adapter.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "students")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @ManyToMany
    @JoinTable(
            name = "student_missions",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "mission_id")
    )
    private List<MissionEntity> assignedMissions; // Cambié Mission a MissionEntity

    // Constructor con parámetros
    public StudentEntity(String name, String email, List<MissionEntity> assignedMissions) {
        this.name = name;
        this.email = email;
        this.assignedMissions = assignedMissions;
    }
}
