package ph.globe.com.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ph.globe.com.spring.dto.AddressDto;
import ph.globe.com.spring.mapper.AddressMapper;
import ph.globe.com.spring.service.AddressService;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @PostMapping("/add")
    public AddressDto addAddress(@RequestBody AddressDto addressDTO){
        return AddressMapper.toAddressDTO(addressService.saveOrUpdate(AddressMapper.toAddress(addressDTO)));
    }

    @GetMapping("findByUserId/{userId}")
    public List<AddressDto> findByUserId(@PathVariable("studNo") long studNo){
        return AddressMapper.toAddressDTOs(addressService.findByStudentAccount(studNo));
    }

    @DeleteMapping("deleteByUserId/{userId}")
    public void deleteByUserId(@PathVariable("userId") long userId){
        addressService.deleteById(userId);
    }
}
