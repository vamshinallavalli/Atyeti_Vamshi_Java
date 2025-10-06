package com.atyeti.Experiments.service;

import com.atyeti.Experiments.dto.StudentDto;
import com.atyeti.Experiments.entity.Student;
import com.atyeti.Experiments.mapper.StudentMapper;
import com.atyeti.Experiments.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    @Autowired
    private StudentMapper mapper;

    public List<StudentDto> getAllStudents() {
        // ✅ no more stream/collect
        return mapper.toDtoList(repository.findAll());
    }

    public StudentDto getById(Long id) {
        Student student = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        return mapper.toDto(student);
    }

    public StudentDto addStudent(StudentDto dto) {
        Student student = mapper.toEntity(dto);
        Student saved = repository.save(student);
        return mapper.toDto(saved);
    }
}