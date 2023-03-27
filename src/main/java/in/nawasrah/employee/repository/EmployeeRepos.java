package in.nawasrah.employee.repository;

import in.nawasrah.employee.database.DbSql;
import in.nawasrah.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeRepos implements RepositoryDB<Employee> {
    private String stringConnection = "jdbc:sqlite:C:\\Users\\nawas\\Desktop\\springBoot\\Employee\\src\\main\\java\\in\\nawasrah\\employee\\database\\data\\employee.db";
    @Autowired
    private DbSql dbSql;
    private Connection con;

    private Connection connection() {
        con = dbSql.connection(this.stringConnection);
        String sql = "CREATE TABLE IF NOT EXISTS employees (" +
                "  id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "  name TEXT NOT NULL," +
                "  age INTEGER NOT NULL," +
                "  email TEXT NOT NULL," +
                "  location TEXT," +
                "  department TEXT" +
                ")";
        dbSql.createTable(sql, con);
        return con;
    }

    Employee setEmployee(Employee e, ResultSet employees) {
        try {
            e.setId(employees.getLong("id"));
            e.setName(employees.getString("name"));
            e.setAge(employees.getInt("age"));
            e.setLocation(employees.getString("location"));
            e.setEmail(employees.getString("email"));
            e.setDepartment(employees.getString("department"));
            return e;
        } catch (Exception exception) {
            return null;
        }
    }

    @Override
    public List<Employee> findAll() {
        try {
            String sql = "SELECT * FROM employees";
            if (connection() != null) {
                ResultSet employees = dbSql.select(sql, connection());
                List<Employee> employeeList = new ArrayList<>();
                while (employees.next()) {
                    Employee e = new Employee();
                    setEmployee(e, employees);
                    employeeList.add(e);
                }
                return employeeList;
            }
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Employee findById(long id) {
        try {
            String sql = "SELECT * FROM employees WHERE id="+id+"";
            if (connection() != null) {
                ResultSet employees = dbSql.select(sql, connection());
                Employee e = new Employee();
                while (employees.next()) {
                    e = setEmployee(e, employees);
                }
                return e;
            }
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean updateById(Employee employee,long id) {
        try {
            String sql = "UPDATE employees" +
                    "SET name = '"+employee.getName()+"', age ="+employee.getAge()+" ," +
                    "email='"+employee.getEmail()+"' , location ='"+employee.getLocation()+"'" +
                    "department ='"+employee.getDepartment()+"'" +
                    "WHERE id="+id+"";
            if (connection() != null) {
                boolean ifUpdate = dbSql.update(sql, connection());
                return ifUpdate;
            }
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
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
