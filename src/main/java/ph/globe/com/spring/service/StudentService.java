package ph.globe.com.spring.service;

import ph.globe.com.spring.entity.Student;

public interface StudentService {
    Student saveOrUpdate (Student student);

    Student findById(Long id);

    void deleteById(Long id);
}
