package com.jorch.TechQuest.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Skill {

    private Long id;
    private String name;

    // Constructor con parámetros
    public Skill(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
