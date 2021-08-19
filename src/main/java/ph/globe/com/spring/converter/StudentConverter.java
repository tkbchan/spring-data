package ph.globe.com.spring.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ph.globe.com.spring.dto.StudentDto;
import ph.globe.com.spring.entity.Student;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentConverter {
    public StudentDto entityToDto(Student student){
        //StudentDto dto = new StudentDto();
        //dto.setStudNo(student.getStudNo());
        //dto.setName(student.getName());
        //dto.setUsername(student.getUsername());
        //dto.setPassword(student.getPassword());

        //return dto;

        ModelMapper mapper = new ModelMapper();
        StudentDto map = mapper.map(student, StudentDto.class);
        return map;
    }

    public List<StudentDto> entityToDto(List<Student> student){
        return student.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
    }

    public Student dtoToEntity(StudentDto studentDto){
        //Student std = new Student();
        //std.setStudNo(studentDto.getStudNo());
        //std.setName(studentDto.getName());
        //std.setUsername(studentDto.getUsername());
        //std.setPassword(studentDto.getPassword());

        //return std;

        ModelMapper mapper = new ModelMapper();
        Student map = mapper.map(studentDto, Student.class);
        return map;
    }

    public List<Student> dtoToEntity(List<StudentDto> studentDto){
        return studentDto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}
