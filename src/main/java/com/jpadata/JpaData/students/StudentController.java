package com.jpadata.JpaData.students;

import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
public class StudentController {


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
