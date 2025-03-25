package com.jpadata.JpaData.students;

import com.jpadata.JpaData.students.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//create interface, extend it to jparepository to create a JPA REPOSITORY  // so we can use all its methods

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findAllByFirstNameContaining(String param);   //how to include new method findAllByFirstName in JpaRepository
}