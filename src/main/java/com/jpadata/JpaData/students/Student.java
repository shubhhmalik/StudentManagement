package com.jpadata.JpaData.students;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.jpadata.JpaData.school.School;
import com.jpadata.JpaData.studentprofile.StudentProfile;
import jakarta.persistence.*;

@Entity    //to make it an entity that we can use in db
@Table(name = "Students")   //if we don't use @Table then by default the name of entity will be same as class
public class Student {

    @Id  //ie student id is our primary key @Id mean primary key
    @GeneratedValue    //basically provides values created by the DB/hibernate itself
    private Integer id;

    @Column(name = "Name", length = 20)   //to have different name and size than default
    private String firstName;

    @Column(updatable = false)  //so that once mentioned cant be updated later eg for date of creation etc
    private String lastName;

    @Column(unique = true)    //to make the atribute unique, so it can not be same in two
    private String email;
    private int age;


    //empty constructor 
    public Student(){

    }

    @OneToOne(
            mappedBy = "student",
            cascade = CascadeType.ALL
    )
    private StudentProfile studentProfile;

    @ManyToOne
    @JoinColumn(
          name = "school-id"
    )
    @JsonBackReference  //to show this is te child, of parent School
    private School school;
    public Student(String firstName, String lastName, String email, int age){

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }
}
