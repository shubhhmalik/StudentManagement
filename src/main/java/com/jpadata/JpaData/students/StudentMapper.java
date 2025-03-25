package com.jpadata.JpaData.students;

import com.jpadata.JpaData.school.School;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {
    //to convert and connect studentdto with student so with school too, cuz school - parent
    public Student toStudent(StudentDto dto){
        var student = new Student();
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());

        //now school
        var school = new School();
        school.setId(dto.schoolId());

        //assign school object to student
        student.setSchool(school);

        return student;
    }

    //now to return studenresponsedto using above
    public StudentResponseDto tostudentResponseDto(Student student){
        return new StudentResponseDto(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );
    }

}
