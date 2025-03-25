package com.jpadata.JpaData.students;

public record StudentDto(
        String firstName,
        String lastName,
        String email,
        Integer schoolId   //cuz student is mapped with its parent level school
){
}
