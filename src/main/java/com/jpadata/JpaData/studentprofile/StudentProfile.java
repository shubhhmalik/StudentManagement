package com.jpadata.JpaData.studentprofile;


import com.jpadata.JpaData.students.Student;
import jakarta.persistence.*;

@Entity
public class StudentProfile {
    public StudentProfile(){
    }

    @Id
    @GeneratedValue
    private Integer id;
    private String bio;
    public StudentProfile(String bio){
        this.bio = bio;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @OneToOne
    @JoinColumn(
            name = "student-id"    //foreign key
    )
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
