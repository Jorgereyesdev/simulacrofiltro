package com.jorch.TechQuest.application.controllers;

import com.jorch.TechQuest.application.dto.request.MissionRequest;
import com.jorch.TechQuest.application.infrastructure.adapter.persistence.entity.MissionEntity;
import com.jorch.TechQuest.application.infrastructure.adapter.persistence.mapper.MissionMapper;
import com.jorch.TechQuest.application.services.MissionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missions")
@Validated
public class MissionController {

    private final MissionService missionService;
    private final MissionMapper missionMapper; // Inyecta el Mapper

    @Autowired
    public MissionController(MissionService missionService, MissionMapper missionMapper) {
        this.missionService = missionService;
        this.missionMapper = missionMapper;
    }

    @GetMapping
    public List<MissionEntity> getAllMissions() {
        return missionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MissionEntity> getMissionById(@PathVariable Long id) {
        MissionEntity mission = missionService.findById(id);
        return (mission != null) ? ResponseEntity.ok(mission) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public MissionEntity createMission(@Valid @RequestBody MissionRequest missionRequest) {
        // Usar el Mapper para convertir MissionRequest a MissionEntity
        MissionEntity missionEntity = missionMapper.toEntity(missionRequest);
        return missionService.createMission(missionEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MissionEntity> updateMission(@PathVariable Long id, @Valid @RequestBody MissionRequest missionRequest) {
        // Usar el Mapper para convertir MissionRequest a MissionEntity
        MissionEntity missionEntity = missionMapper.toEntity(missionRequest);
        missionEntity.setId(id); // Asegúrate de asignar el ID para la actualización
        MissionEntity updatedMission = missionService.updateMission(id, missionEntity);
        return (updatedMission != null) ? ResponseEntity.ok(updatedMission) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMission(@PathVariable Long id) {
        missionService.deleteMission(id);
        return ResponseEntity.noContent().build();
    }
}
