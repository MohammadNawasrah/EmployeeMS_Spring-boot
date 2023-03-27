package in.nawasrah.employee.controller;

//import in.nawasrah.employee.database.DB;
//import in.nawasrah.employee.database.DbSql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/employees")

@RestController
public class EmployeeController {
    @Autowired
//    DB sqlDB=new DbSql();
    @GetMapping("/")
    public String displayEmployees(){
        String connectionString="jdbc:sqlite:C:\\Users\\nawas\\Desktop\\springBoot\\Employee\\src\\main\\java\\in\\nawasrah\\employee\\database\\data\\test.db";
        return "displayEmployees";
    }
}
