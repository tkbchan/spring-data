package ph.globe.com.spring.dto;


import lombok.Data;

@Data
public class StudentDto {

    private Long studNo;
    private String name;
    private String username;
    private String password;
    private String program;
    private AddressDto address;
}
