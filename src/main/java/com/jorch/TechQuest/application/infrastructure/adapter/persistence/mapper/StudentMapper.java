package com.jorch.TechQuest.application.infrastructure.adapter.persistence.mapper;

import com.jorch.TechQuest.application.dto.request.StudentRequest;
import com.jorch.TechQuest.application.infrastructure.adapter.persistence.entity.StudentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentEntity toEntity(StudentRequest studentRequest);

    StudentRequest toRequest(StudentEntity studentEntity);
}
