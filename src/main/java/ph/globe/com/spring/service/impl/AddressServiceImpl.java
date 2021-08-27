package ph.globe.com.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ph.globe.com.spring.entity.Address;
import ph.globe.com.spring.entity.Student;
import ph.globe.com.spring.mapper.AddressMapper;
import ph.globe.com.spring.repository.AddressRepository;
import ph.globe.com.spring.repository.StudentJpaRepository;
import ph.globe.com.spring.service.AddressService;
import ph.globe.com.spring.service.StudentService;

import java.util.List;
import java.util.Optional;

public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    StudentService studentService;
    @Autowired
    StudentJpaRepository studentJpaRepository;

    @Override
    public Address saveOrUpdate(Address address) {
        if(address.getId() != null){
            Address addressData = addressRepository.getOne(address.getId());
            if(addressData == null){

            }
            addressData = AddressMapper.toUpdateAddress(addressData, address);
            if(address.getAcctId() != null){
                Student student = studentService.findById(address.getAcctId());
                address.setStudentAccount(student);
            }
            return addressRepository.save(addressData);
        }
        if (address.getAcctId() != null){
            Student student = studentService.findById(address.getAcctId());
            address.setStudentAccount(student);
        }
        return addressRepository.save(address);
    }

    @Override
    public Optional<Address> findById(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        addressRepository.deleteById(id);
    }

    @Override
    public List<Address> findByStudentAccount(Long studNo) {
        Student student = studentService.findById(studNo);
        return addressRepository.findByStudentAccount(student);
    }
}
