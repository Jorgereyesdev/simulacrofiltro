package com.jorch.TechQuest.application.services;

import com.jorch.TechQuest.application.infrastructure.adapter.persistence.entity.StudentEntity;
import com.jorch.TechQuest.application.infrastructure.adapter.persistence.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentEntity> findAll() {
        return studentRepository.findAll();
    }

    public StudentEntity findById(Long id) {
        return studentRepository.findById(id).orElse(null); // Puedes lanzar una excepción si no se encuentra
    }

    public StudentEntity createStudent(StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }

    public StudentEntity updateStudent(Long id, StudentEntity studentEntity) {
        // Lógica para actualizar el estudiante
        if (studentRepository.existsById(id)) {
            studentEntity.setId(id); // Asegúrate de que el ID esté correcto
            return studentRepository.save(studentEntity);
        }
        return null; // O lanzar una excepción
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
