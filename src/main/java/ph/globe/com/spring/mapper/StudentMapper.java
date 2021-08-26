package ph.globe.com.spring.mapper;

import ph.globe.com.spring.dto.StudentDto;
import ph.globe.com.spring.entity.Student;

public class StudentMapper {
    public static Student toStudent(StudentDto studentDto){
        if(studentDto == null){
            return null;
        }

        return Student.builder()
                .studNo(studentDto.getStudNo())
                .name(studentDto.getName())
                .username(studentDto.getUsername())
                .password(studentDto.getPassword())
                .program(studentDto.getProgram())
                .build();
    }

    public static StudentDto toStudentDto(Student student){
        if(student == null){
            return null;
        }

        return StudentDto.builder()
                .studNo(student.getStudNo())
                .name(student.getName())
                .username(student.getUsername())
                .password(student.getPassword())
                .program(student.getProgram())
                .build();
    }

    public static Student toUpdateStudent(Student student, Student updateStudent){
        student.setProgram(updateStudent.getProgram() == null ? student.getProgram() : updateStudent.getProgram());
        student.setName(updateStudent.getName() == null ? student.getName() : updateStudent.getName());
        student.setUsername(updateStudent.getUsername() == null ? student.getUsername() : updateStudent.getUsername());
        student.setPassword(updateStudent.getPassword() == null ? student.getPassword() : updateStudent.getPassword());
        return student;
    }
}
