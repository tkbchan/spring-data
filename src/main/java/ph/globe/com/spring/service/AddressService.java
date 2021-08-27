package ph.globe.com.spring.service;

import org.springframework.context.annotation.Bean;
import ph.globe.com.spring.entity.Address;

import java.util.List;
import java.util.Optional;
public interface AddressService {
    Address saveOrUpdate (Address user);

    Optional<Address> findById(Long id);

    void deleteById(Long id);

    List<Address> findByStudentAccount(Long studNo);
}
