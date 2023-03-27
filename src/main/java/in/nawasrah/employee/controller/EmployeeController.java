package in.nawasrah.employee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/employees")
@RestController
public class EmployeeController {
    @GetMapping("/")
    public String displayEmployees(){
        return "displayEmployees";
    }
}
