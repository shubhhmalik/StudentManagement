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
        return dto; 
    }

    @GetMapping("/schoolsdto")
    public List<SchoolDto> findAllSt(){
        return schoolRepository.findAll()
                .stream()
                .map(schoolMapper::toschoolDto)
                .collect(Collectors.toList());
    }
}
