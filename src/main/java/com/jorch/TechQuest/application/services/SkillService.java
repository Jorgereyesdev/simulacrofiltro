package com.jorch.TechQuest.application.services;

import com.jorch.TechQuest.application.infrastructure.adapter.persistence.entity.SkillEntity;
import com.jorch.TechQuest.application.infrastructure.adapter.persistence.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

    private final SkillRepository skillRepository;

    @Autowired
    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public List<SkillEntity> findAll() {
        return skillRepository.findAll();
    }

    public SkillEntity findById(Long id) {
        return skillRepository.findById(id).orElse(null); // Puedes lanzar una excepción si no se encuentra
    }

    public SkillEntity createSkill(SkillEntity skillEntity) {
        return skillRepository.save(skillEntity);
    }

    public SkillEntity updateSkill(Long id, SkillEntity skillEntity) {
        // Lógica para actualizar la habilidad
        if (skillRepository.existsById(id)) {
            skillEntity.setId(id); // Asegúrate de que el ID esté correcto
            return skillRepository.save(skillEntity);
        }
        return null; // O lanzar una excepción
    }

    public void deleteSkill(Long id) {
        skillRepository.deleteById(id);
    }
}
