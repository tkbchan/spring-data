package ph.globe.com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import ph.globe.com.spring.model.Student;

@Component
public interface StudentJpaRepository extends JpaRepository<Student, Long> {
    Student findByName(String name);

}
