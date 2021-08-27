package ph.globe.com.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ph.globe.com.spring.entity.Student;
import ph.globe.com.spring.repository.StudentJpaRepository;
import ph.globe.com.spring.service.StudentService;

import java.util.Optional;

public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentJpaRepository studentJpaRepository;

    @Override
    public Student saveOrUpdate(Student student) {
        if (student.getStudNo() != null){
            Student studentData = studentJpaRepository.getOne(student.getStudNo());
            if (studentData == null){
                return null;
            }
            studentData.setName(student.getName());
            studentData.setUsername(student.getUsername());
            studentData.setPassword(student.getPassword());
            studentData.setProgram(student.getProgram());
            return studentJpaRepository.save(studentData);
        }
        return studentJpaRepository.save(student);
    }

    @Override
    public Student findById(Long id) {
        Optional<Student> studentOptional =  studentJpaRepository.findById(id);
        return studentOptional.orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        studentJpaRepository.deleteById(id);
    }
}
