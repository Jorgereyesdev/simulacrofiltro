package com.jorch.TechQuest.application.services;

import com.jorch.TechQuest.application.infrastructure.adapter.persistence.entity.MissionAssignmentEntity;
import com.jorch.TechQuest.application.infrastructure.adapter.persistence.repository.MissionAssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissionAssignmentService {

    private final MissionAssignmentRepository missionAssignmentRepository;

    @Autowired
    public MissionAssignmentService(MissionAssignmentRepository missionAssignmentRepository) {
        this.missionAssignmentRepository = missionAssignmentRepository;
    }

    public List<MissionAssignmentEntity> findAll() {
        return missionAssignmentRepository.findAll();
    }

    public MissionAssignmentEntity findById(Long id) {
        return missionAssignmentRepository.findById(id).orElse(null); // Puedes lanzar una excepción si no se encuentra
    }

    public MissionAssignmentEntity createAssignment(MissionAssignmentEntity missionAssignmentEntity) {
        return missionAssignmentRepository.save(missionAssignmentEntity);
    }

    public void deleteAssignment(Long id) {
        missionAssignmentRepository.deleteById(id);
    }
}
