package ph.globe.com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ph.globe.com.spring.converter.StudentConverter;
import ph.globe.com.spring.dto.StudentDto;
import ph.globe.com.spring.entity.Student;
import ph.globe.com.spring.repository.StudentJpaRepository;

import java.util.List;

@RestController
@RequestMapping("/create-student")
public class UserController {
    @Autowired
    private StudentJpaRepository studentJpaRepository;
    @Autowired
    private StudentConverter studentConverter;

    @GetMapping(value = "/all")
    public List<StudentDto> findAll(){
        List<Student> findAll = studentJpaRepository.findAll();
        return studentConverter.entityToDto(findAll);
    }

    @GetMapping(value = "/{studNo}")
    public StudentDto findById(@PathVariable(value = "studNo") Long studNo){
        Student orElse = studentJpaRepository.findById(studNo).orElse(null);
        return studentConverter.entityToDto(orElse);
    }

    @PostMapping(value = "/save")
    public StudentDto save(@RequestBody StudentDto dto){
        Student student = studentConverter.dtoToEntity(dto);
        studentJpaRepository.save(student);
        return studentConverter.entityToDto(student);
    }


}
