package com.jorch.TechQuest.application.infrastructure.adapter.persistence.mapper;

import com.jorch.TechQuest.application.dto.request.MissionRequest;
import com.jorch.TechQuest.application.infrastructure.adapter.persistence.entity.MissionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MissionMapper {
    MissionEntity toEntity(MissionRequest missionRequest);
    MissionRequest toRequest(MissionEntity missionEntity);
}
