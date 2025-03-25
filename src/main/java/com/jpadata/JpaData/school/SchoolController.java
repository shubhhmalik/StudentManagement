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
