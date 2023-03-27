package in.nawasrah.employee.controller;

import in.nawasrah.employee.model.Employee;
import in.nawasrah.employee.service.EmployeeService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RequestMapping(value = "/employees")

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("")
    public List<Employee> displayEmployees(HttpServletResponse httpResponse) throws IOException {
        List<Employee> employees = employeeService.getAllEmployee();
        if (employees != null) {
            return employees;
        } else {
            httpResponse.sendRedirect("error");
            return null;
        }
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }

    @GetMapping("/{id}")
    public Employee displayEmployee(@PathVariable("id") long id, HttpServletResponse httpResponse) throws IOException {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            return employee;
        } else {
            httpResponse.sendRedirect("error");
            return null;
        }
    }

    @PostMapping("/employee")
    public String saveNewEmployee(@RequestBody Employee employee ,HttpServletResponse httpResponse) throws IOException {
        String e = employeeService.saveEmployee(employee);
        return e;
    }
    @PutMapping("/employee/{id}")
    public String updateEmployee(@PathVariable("id") long id,@RequestBody Employee employee ,HttpServletResponse httpResponse) throws IOException {
        String e = employeeService.updateEmployee(employee,id);
        return e;
    }
    @DeleteMapping("/employee")
    public String deleteEmployee(@RequestParam("id") long id,HttpServletResponse httpResponse) throws IOException {
        String e = employeeService.deleteEmployee(id);
        return e;
    }
}