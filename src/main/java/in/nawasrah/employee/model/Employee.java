package in.nawasrah.employee.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Employee {
    public long id;
    public String name;
    public int age;
    public String email;
    public String location;
    public String department;
}
