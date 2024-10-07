package com.jorch.TechQuest.application.controllers;

import com.jorch.TechQuest.application.dto.request.StudentRequest;
import com.jorch.TechQuest.application.infrastructure.adapter.persistence.entity.StudentEntity;
import com.jorch.TechQuest.application.infrastructure.adapter.persistence.mapper.StudentMapper;
import com.jorch.TechQuest.application.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@Validated
public class StudentController {

    private final StudentService studentService;
    private final StudentMapper studentMapper;

    @Autowired
    public StudentController(StudentService studentService, StudentMapper studentMapper) {
        this.studentService = studentService;
        this.studentMapper = studentMapper;
    }

    @GetMapping
    public List<StudentEntity> getAllStudents() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentEntity> getStudentById(@PathVariable Long id) {
        StudentEntity student = studentService.findById(id);
        return (student != null) ? ResponseEntity.ok(student) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public StudentEntity createStudent(@Valid @RequestBody StudentRequest studentRequest) {
        // Usar el Mapper para convertir StudentRequest a StudentEntity
        StudentEntity studentEntity = studentMapper.toEntity(studentRequest);
        return studentService.createStudent(studentEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentEntity> updateStudent(@PathVariable Long id, @Valid @RequestBody StudentRequest studentRequest) {
        // Usar el Mapper para convertir StudentRequest a StudentEntity
        StudentEntity studentEntity = studentMapper.toEntity(studentRequest);
        studentEntity.setId(id); // Asegúrate de asignar el ID para la actualización
        StudentEntity updatedStudent = studentService.updateStudent(id, studentEntity);
        return (updatedStudent != null) ? ResponseEntity.ok(updatedStudent) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
