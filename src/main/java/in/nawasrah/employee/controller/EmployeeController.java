package in.nawasrah.employee.controller;

import in.nawasrah.employee.model.Employee;
import in.nawasrah.employee.service.EmployeeService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/employees")

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    private HttpServletResponse httpResponse;

    @GetMapping("")
    public List<Employee> displayEmployees() {
        return  employeeService.getAllEmployee();
    }
    @GetMapping("/error")
    public String error() {
        return  "error";
    }
    @GetMapping("/{id}")
    public Employee displayEmployee(@PathVariable("id") long id)  {
        Employee employee=employeeService.getEmployeeById(id);
        if (employee.getName()!=null){
            return employee;
        }else{
            try{
                httpResponse.sendRedirect("/error");
            }catch (Exception e){

            }
            return null;
        }
    }
}
