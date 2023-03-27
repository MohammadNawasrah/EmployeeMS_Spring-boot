package in.nawasrah.employee.controller;

//import in.nawasrah.employee.database.DB;
//import in.nawasrah.employee.database.DbSql;

import in.nawasrah.employee.repository.EmployeeRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/employees")

@RestController
public class EmployeeController {
    @Autowired
    EmployeeRepos employeeRepos;

    @GetMapping("/")
    public String displayEmployees() {
        return "displayEmployees" + employeeRepos.findAll();
    }
}
