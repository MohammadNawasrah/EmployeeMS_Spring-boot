package in.nawasrah.employee.service;

import in.nawasrah.employee.model.Employee;
import in.nawasrah.employee.repository.EmployeeRepos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService extends EmployeeRepos {
    public List<Employee> getAllEmployee() {
        return findAll();
    }

    public Employee getEmployeeById(long id) {
        return findById(id);
    }

    public String saveEmployee(Employee employee) {
        if (insert(employee))
            return "Done Save";
        else
            return "error";
    }

    public String updateEmployee(Employee employee ,long id) {
        if (updateById(employee,id))
            return "Done update";
        else
            return "error";
    }

    public String deleteEmployee(Employee employee ,long id) {
        if (remove(id))
            return "Done remove";
        else
            return "error";
    }
}
