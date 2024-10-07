package com.jorch.TechQuest.application.controllers;

import com.jorch.TechQuest.application.infrastructure.adapter.persistence.entity.MissionAssignmentEntity;
import com.jorch.TechQuest.application.services.MissionAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mission-assignments")
public class MissionAssignmentController {

    private final MissionAssignmentService missionAssignmentService;

    @Autowired
    public MissionAssignmentController(MissionAssignmentService missionAssignmentService) {
        this.missionAssignmentService = missionAssignmentService;
    }

    @GetMapping
    public List<MissionAssignmentEntity> getAllAssignments() {
        return missionAssignmentService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MissionAssignmentEntity> getAssignmentById(@PathVariable Long id) {
        MissionAssignmentEntity assignment = missionAssignmentService.findById(id);
        return (assignment != null) ? ResponseEntity.ok(assignment) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public MissionAssignmentEntity createAssignment(@RequestBody MissionAssignmentEntity missionAssignmentEntity) {
        return missionAssignmentService.createAssignment(missionAssignmentEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssignment(@PathVariable Long id) {
        missionAssignmentService.deleteAssignment(id);
        return ResponseEntity.noContent().build();
    }
}
