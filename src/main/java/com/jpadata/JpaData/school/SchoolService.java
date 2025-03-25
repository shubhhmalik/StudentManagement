package com.jpadata.JpaData.school;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {
    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;

    public SchoolService(SchoolRepository schoolRepository, SchoolMapper schoolMapper) {
        this.schoolRepository = schoolRepository;
        this.schoolMapper = schoolMapper;
    }


    public SchoolDto create(SchoolDto dto){
        var school = schoolMapper.toSchool(dto);
        schoolRepository.save(school);
        return dto;  //input and return value same type so we can do it
    }

    @GetMapping("/schoolsdto")
    //Step 1: Fetch all schools from the database, findAll
    //Step 2: Convert the list of schools into a stream, .stream
    //Step 3: Transform each School object into a SchoolDto object, .map
    //Step 4: Collect the transformed objects into a list, .collect
    public List<SchoolDto> findAllSt(){
        return schoolRepository.findAll()
                .stream()
                .map(schoolMapper::toschoolDto)
                .collect(Collectors.toList());
    }
}
