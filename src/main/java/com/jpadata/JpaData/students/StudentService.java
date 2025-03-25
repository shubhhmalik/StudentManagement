package com.jpadata.JpaData.students;

import com.jpadata.JpaData.students.StudentDto;
import com.jpadata.JpaData.students.StudentMapper;
import com.jpadata.JpaData.students.StudentRepository;
import com.jpadata.JpaData.students.StudentResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    //injecting interface
    private final StudentRepository repository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository repository, StudentMapper studentMapper) {
        this.repository = repository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDto saveStudent(StudentDto dto){    //method for the method admission in controller
        var student = studentMapper.toStudent(dto);
        //for dto response student, below line
        var savedStudent = repository.save(student);
        return studentMapper.tostudentResponseDto(savedStudent);
    }

    public List<StudentResponseDto> findStudentByName(String name){
        return repository.findAllByFirstNameContaining(name)
                .stream()
                .map(studentMapper::tostudentResponseDto)
                .collect(Collectors.toList());
         }

    public List<StudentResponseDto> findAllStuds(){
        return repository.findAll()
                .stream()
                .map(studentMapper::tostudentResponseDto)
                .collect(Collectors.toList());
    }
}
