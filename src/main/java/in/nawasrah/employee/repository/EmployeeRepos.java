package in.nawasrah.employee.repository;

import in.nawasrah.employee.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeRepos implements RepositoryDB<Employee> {
    private static String stringConnection="jdbc:sqlite:C:\\Users\\nawas\\Desktop\\springBoot\\Employee\\src\\main\\java\\in\\nawasrah\\employee\\database\\data\\employee.db";

}
