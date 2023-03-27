package in.nawasrah.employee.repository;

import in.nawasrah.employee.database.data.DbSql;
import in.nawasrah.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeRepos implements RepositoryDB<Employee> {
    private String stringConnection = "jdbc:sqlite:C:\\Users\\nawas\\Desktop\\springBoot\\Employee\\src\\main\\java\\in\\nawasrah\\employee\\database\\data\\employee.db";
    @Autowired
    private DbSql dbSql;

    private Connection connection() {
        Connection con = dbSql.connection(this.stringConnection);
        return con;
    }

    @Override
    public List<Employee> findAll() {
        try {
            String sql = "SELECT * FROM employee";
            ResultSet employees = dbSql.select(sql, connection());
            List<Employee> employeeList = new ArrayList<>();
            while (employees.next()) {
                Employee e=new Employee();
                e.setId(employees.getLong("id"));
                e.setName(employees.getString("name"));
                e.setAge(employees.getInt("age"));
                e.setLocation(employees.getString("location"));
                e.setEmail(employees.getString("email"));
                e.setDepartment(employees.getString("department"));
                employeeList.add(e);
            }
            return employeeList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Employee findById(long id) {
        return null;
    }

    @Override
    public boolean updateById(long id) {
        return false;
    }

    @Override
    public boolean remove(long id) {
        return false;
    }

    @Override
    public boolean insert(Employee data) {
        return false;
    }
}
