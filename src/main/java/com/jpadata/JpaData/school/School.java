package com.jpadata.JpaData.school;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jpadata.JpaData.students.Student;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class School {

    public School(String name){

    }

    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    public School() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(
            mappedBy = "school"
    )
    @JsonManagedReference  //to avoid infinite recursion loop
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
