package ph.globe.com.spring.mapper;

import ph.globe.com.spring.dto.AddressDto;
import ph.globe.com.spring.entity.Address;

import java.util.List;
import java.util.stream.Collectors;

public class AddressMapper {
    public static Address toAddress(AddressDto addressDTO){
        if (addressDTO == null) {
            return null;
        }
        return Address.builder()
                .city(addressDTO.getCity())
                .country(addressDTO.getCountry())
                .studentAccount(StudentMapper.toStudent(addressDTO.getStudentAccount()))
                .acctId(addressDTO.getAcctId())
                .build();
    }

    public static AddressDto toAddressDTO(Address address){
        if (address == null) {
            return null;
        }
        return AddressDto.builder()
                .city(address.getCity())
                .country(address.getCountry())
                .studentAccount(StudentMapper.toStudentDto(address.getStudentAccount()))
                .acctId(address.getAcctId())
                .build();
    }

    public static Address toUpdateAddress(Address address, Address updateAddress){

        address.setAcctId(updateAddress.getAcctId() == null ? address.getAcctId() : updateAddress.getAcctId());
        address.setCity(updateAddress.getCity() == null ? address.getCity() : updateAddress.getCity());
        address.setCountry(updateAddress.getCountry() == null ? address.getCountry() : updateAddress.getCountry());

        return address;
    }

    public static List<Address> toAddresses(List<AddressDto> addressDTOS){
        return addressDTOS.stream().map(a ->  toAddress(a)).collect(Collectors.toList());
    }

    public static List<AddressDto> toAddressDTOs(List<Address> addresses){
        return addresses.stream().map(a ->  toAddressDTO(a)).collect(Collectors.toList());
    }
}
