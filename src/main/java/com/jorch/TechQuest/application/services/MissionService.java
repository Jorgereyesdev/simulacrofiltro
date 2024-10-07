package com.jorch.TechQuest.application.services;

import com.jorch.TechQuest.application.infrastructure.adapter.persistence.entity.MissionEntity;
import com.jorch.TechQuest.application.infrastructure.adapter.persistence.repository.MissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissionService {

    private final MissionRepository missionRepository;

    @Autowired
    public MissionService(MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    public List<MissionEntity> findAll() {
        return missionRepository.findAll();
    }

    public MissionEntity findById(Long id) {
        return missionRepository.findById(id).orElse(null); // Puedes lanzar una excepción si no se encuentra
    }

    public MissionEntity createMission(MissionEntity missionEntity) {
        return missionRepository.save(missionEntity);
    }

    public MissionEntity updateMission(Long id, MissionEntity missionEntity) {
        // Lógica para actualizar la misión
        if (missionRepository.existsById(id)) {
            missionEntity.setId(id); // Asegúrate de que el ID esté correcto
            return missionRepository.save(missionEntity);
        }
        return null; // O lanzar una excepción
    }

    public void deleteMission(Long id) {
        missionRepository.deleteById(id);
    }
}
