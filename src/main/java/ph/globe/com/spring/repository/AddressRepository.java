package ph.globe.com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ph.globe.com.spring.entity.Address;
import ph.globe.com.spring.entity.Student;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByStudentAccount (Student studentAcc);
}
