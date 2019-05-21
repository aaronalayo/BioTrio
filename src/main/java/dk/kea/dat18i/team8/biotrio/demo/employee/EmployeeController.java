package dk.kea.dat18i.team8.biotrio.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepo;

    @GetMapping("/employeeview")
    @ResponseBody
    public Employee showEmployee() {


        Employee employee = employeeRepo.findEmployee(1);

        return employee;

    }

    @GetMapping("/employees")
    public String screening(Model model) {


        List<Employee> employeeList = employeeRepo.findAllEmployees();
        model.addAttribute("employeelist", employeeList);


        return "show-employees";

    }

    @GetMapping("/addemployee")
    public String addEmployee(Model model) {



       Employee employeeList = new Employee();

        model.addAttribute(  "employeelist", employeeList );


        return "add-employee";
    }

    @PostMapping("/saveemployee")
    public String saveScreening(@ModelAttribute Employee employee){

        Employee newEmployee = new Employee();

        newEmployee.setName( employee.getName() );
        newEmployee.setLastName( employee.getLastName() );
        newEmployee.setUsername( employee.getUsername() );
        newEmployee.setPassword( employee.getPassword() );

        employeeRepo.addEmployee(newEmployee);

        return "redirect:/employees";
    }

    @RequestMapping(value = "employees/delete/{employee_id}")
    public String removeScreening(@PathVariable int employee_id) {

        employeeRepo.deleteEmployee(employee_id);

        return "redirect:/employees";
    }

    @GetMapping("/employees/edit/{employee_id}")
    public String editEmployee(Model model, @PathVariable(name = "employee_id") int employee_id){

        Employee employeeToEdit = employeeRepo.findEmployee(employee_id);
        model.addAttribute("employee", employeeToEdit);

        return "edit-employee";
    }

    @PostMapping("/updateemployee")
    public String saveEditScreening(@ModelAttribute Employee updateEmployee){

        updateEmployee.setName( updateEmployee.getName() );
        updateEmployee.setLastName( updateEmployee.getLastName() );
        updateEmployee.setUsername( updateEmployee.getUsername() );
        updateEmployee.setPassword( updateEmployee.getPassword() );

        employeeRepo.update(updateEmployee);

        return "redirect:/employees";
    }



}
