package in.nawasrah.employee.controller;

//import in.nawasrah.employee.database.DB;
//import in.nawasrah.employee.database.DbSql;

import in.nawasrah.employee.model.Employee;
import in.nawasrah.employee.repository.EmployeeRepos;
import in.nawasrah.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/employees")

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public List<Employee> displayEmployees() {
        return  employeeService.getAllEmployee();
    }
}
