package ph.globe.com.spring.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentDto {

    private Long studNo;
    private String name;
    private String username;
    private String password;
    private String program;
    private AddressDto address;
}
