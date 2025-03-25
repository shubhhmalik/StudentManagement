package com.jpadata.JpaData.school;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {
   private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

//    private final SchoolRepository schoolRepository;
//    @PostMapping("/schools")
//    public School create(@RequestBody School schools){
//        var school = toSchool(schools);
//        schoolRepository.save(school);
//        return school;
//    }
//    }
//    @GetMapping("/schools")
//    public List<School> findAll(){
//        return schoolRepository.findAll();
//    }


    //dto rep
    @PostMapping("/schoolsdto")
    public SchoolDto createS(@RequestBody SchoolDto dto){
       return schoolService.create(dto);
    }


    @GetMapping("/schoolsdto")
    public List<SchoolDto> findAllS(){
        return schoolService.findAllSt();
    }

}
