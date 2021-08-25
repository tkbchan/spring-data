package ph.globe.com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ph.globe.com.spring.dto.StudentDto;
import ph.globe.com.spring.entity.Student;
import ph.globe.com.spring.mapper.StudentMapper;
import ph.globe.com.spring.repository.StudentJpaRepository;
import ph.globe.com.spring.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/create-student")
public class UserController {
    @Autowired
    StudentService studentService;

    @PostMapping("/save")
    public Student createStudent(@RequestBody Student student){
        return studentService.saveOrUpdate(student);
    }

    @GetMapping("/load/{studNo}")
    public StudentDto findUserById(@PathVariable("studNo") long studNo){
        Student userData = studentService.findById(studNo);
        return StudentMapper.toStudentDto(userData);
    }

    @DeleteMapping("delete/{studNo}")
    public void deleteUserByid(@PathVariable("studNo") long studNo){
        studentService.deleteById(studNo);
    }


}
