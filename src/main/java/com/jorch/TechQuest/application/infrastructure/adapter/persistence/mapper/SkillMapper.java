package com.jorch.TechQuest.application.infrastructure.adapter.persistence.mapper;

import com.jorch.TechQuest.application.dto.request.SkillRequest;
import com.jorch.TechQuest.application.infrastructure.adapter.persistence.entity.SkillEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SkillMapper {
    SkillEntity toEntity(SkillRequest skillRequest);
    SkillRequest toRequest(SkillEntity skillEntity);
}
