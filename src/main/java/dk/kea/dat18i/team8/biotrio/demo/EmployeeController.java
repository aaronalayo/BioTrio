package dk.kea.dat18i.team8.biotrio.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {
@GetMapping("/employeeScreen")
    public String employeeScreen(){
        return "employee-screen";
    }

}
