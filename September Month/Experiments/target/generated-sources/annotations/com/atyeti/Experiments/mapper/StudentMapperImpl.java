package com.atyeti.Experiments.mapper;

import com.atyeti.Experiments.dto.StudentDto;
import com.atyeti.Experiments.entity.Student;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-06T12:20:23+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.8 (Oracle Corporation)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public StudentDto toDto(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDto studentDto = new StudentDto();

        studentDto.setId( student.getId() );
        studentDto.setName( student.getName() );
        studentDto.setStandard( student.getStandard() );

        return studentDto;
    }

    @Override
    public Student toEntity(StudentDto dto) {
        if ( dto == null ) {
            return null;
        }

        Student student = new Student();

        if ( dto.getId() != null ) {
            student.setId( dto.getId() );
        }
        student.setName( dto.getName() );
        student.setStandard( dto.getStandard() );

        return student;
    }

    @Override
    public List<StudentDto> toDtoList(List<Student> students) {
        if ( students == null ) {
            return null;
        }

        List<StudentDto> list = new ArrayList<StudentDto>( students.size() );
        for ( Student student : students ) {
            list.add( toDto( student ) );
        }

        return list;
    }

    @Override
    public List<Student> toEntityList(List<StudentDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Student> list = new ArrayList<Student>( dtos.size() );
        for ( StudentDto studentDto : dtos ) {
            list.add( toEntity( studentDto ) );
        }

        return list;
    }
}
