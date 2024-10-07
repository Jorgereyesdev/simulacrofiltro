package com.jorch.TechQuest.application.controllers;

import com.jorch.TechQuest.application.dto.request.SkillRequest;
import com.jorch.TechQuest.application.infrastructure.adapter.persistence.entity.SkillEntity;
import com.jorch.TechQuest.application.infrastructure.adapter.persistence.mapper.SkillMapper;
import com.jorch.TechQuest.application.services.SkillService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skills")
@Validated
public class SkillController {

    private final SkillService skillService;
    private final SkillMapper skillMapper; // Inyecta el Mapper

    @Autowired
    public SkillController(SkillService skillService, SkillMapper skillMapper) {
        this.skillService = skillService;
        this.skillMapper = skillMapper;
    }

    @GetMapping
    public List<SkillEntity> getAllSkills() {
        return skillService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillEntity> getSkillById(@PathVariable Long id) {
        SkillEntity skill = skillService.findById(id);
        return (skill != null) ? ResponseEntity.ok(skill) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public SkillEntity createSkill(@Valid @RequestBody SkillRequest skillRequest) {
        // Usar el Mapper para convertir SkillRequest a SkillEntity
        SkillEntity skillEntity = skillMapper.toEntity(skillRequest);
        return skillService.createSkill(skillEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SkillEntity> updateSkill(@PathVariable Long id, @Valid @RequestBody SkillRequest skillRequest) {
        // Usar el Mapper para convertir SkillRequest a SkillEntity
        SkillEntity skillEntity = skillMapper.toEntity(skillRequest);
        skillEntity.setId(id); // Asegúrate de asignar el ID para la actualización
        SkillEntity updatedSkill = skillService.updateSkill(id, skillEntity);
        return (updatedSkill != null) ? ResponseEntity.ok(updatedSkill) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSkill(@PathVariable Long id) {
        skillService.deleteSkill(id);
        return ResponseEntity.noContent().build();
    }
}
