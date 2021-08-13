package ph.globe.com.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {
    private Long studNo;
    private String name;
    private String program;

    @Id
    @GeneratedValue
    public Long getStudNo() {
        return studNo;
    }

    public void setStudNo(Long studNo) {
        this.studNo = studNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }
}
