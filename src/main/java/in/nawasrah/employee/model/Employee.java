package in.nawasrah.employee.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Employee {
    private long id;
    private String name;
    private int age;
    private String email;
    private String location;
    private String department;
}
