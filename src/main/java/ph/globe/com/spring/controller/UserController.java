package ph.globe.com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ph.globe.com.spring.model.Student;
import ph.globe.com.spring.repository.StudentJpaRepository;

import java.util.List;

@RestController
@RequestMapping("/create-student")
public class UserController {
    @Autowired
    private StudentJpaRepository studentJpaRepository;

    @GetMapping(value = "/all")
    public List<Student> findAll(){
        return studentJpaRepository.findAll();
    }

    @GetMapping(value = "/{name}")
    public Student findByName(@PathVariable final String name){
        return studentJpaRepository.findByName(name);
    }

    @PostMapping(value = "/load")
    public Student load(@RequestBody  final Student student){

        studentJpaRepository.save(student);
        return studentJpaRepository.findByName(student.getName());
    }

    public Student createStudent(@PathVariable final String name){
        return studentJpaRepository.findByName(name);
    }
}
