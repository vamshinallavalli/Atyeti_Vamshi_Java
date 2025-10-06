package com.atyeti.Experiments.mapper;

import com.atyeti.Experiments.dto.StudentDto;
import com.atyeti.Experiments.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDto toDto(Student student);

    Student toEntity(StudentDto dto);

    // ✅ List mapping
    List<StudentDto> toDtoList(List<Student> students);

    List<Student> toEntityList(List<StudentDto> dtos);
}