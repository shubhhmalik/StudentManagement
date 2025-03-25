package com.jpadata.JpaData.students;

import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
public class StudentController {

//    @GetMapping("/hello")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public String sayHello() {
//        return "hello from my first controller";
//    }
//
//    @PostMapping("/students")
//    public Student admission(@RequestBody Student student) {
//        return repository.save(student);  //basically saves the entity we give to it and returns it
//    }


//    @GetMapping("/students")
//    public List<Student> findAllStuds(){
//        return repository.findAll();
//    }
//
//    @GetMapping("/students/{student-id}")
//    public Student findStudentById(@PathVariable("student-id") Integer id){
//        return repository.findById(id).orElse(new Student());   //we can also mention null here
//    }

//    @GetMapping("/students/search/{student-name}")
//    public List<Student> findStudentByName(@PathVariable("student-name") String name){
//        return repository.findAllByFirstNameContaining(name);
   // }

//    @DeleteMapping("/student/{st-id}")
//    @ResponseStatus(HttpStatus.OK)
//    public Student delete(@PathVariable("st-id") Integer id){
//        return repository.deleteById(id);
//    }

    //USING DTO AND SERVICE LAYER
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //use dto
    @PostMapping("/studentsdto")
    public StudentResponseDto admission(@RequestBody StudentDto studentdto){  //trying a diff representation via DTO
        return this.studentService.saveStudent(studentdto);
    }

    @GetMapping("/students/search/{student-name}")
    public List<StudentResponseDto> findStudentByName(@PathVariable("student-name") String name){
        return this.studentService.findStudentByName(name);
     }


     @GetMapping("/students")
    public List<StudentResponseDto> findAllStuds(){
        return studentService.findAllStuds();
   }


}
