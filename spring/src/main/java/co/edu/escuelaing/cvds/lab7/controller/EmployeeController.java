package co.edu.escuelaing.cvds.lab7.controller;

import co.edu.escuelaing.cvds.lab7.model.Configuration;
import co.edu.escuelaing.cvds.lab7.model.Employee;
import co.edu.escuelaing.cvds.lab7.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
	private final EmployeeService employeeService;

	@Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
	
	@GetMapping("/api/employees")
    @ResponseBody
    public List<Employee> exampleApiConfigurations() {
        return employeeService.getAllEmployees();
    }
	@PostMapping("/api/employees")
    @ResponseBody
    public List<Employee> exampleApiConfigurations(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);	
        return employeeService.getAllEmployees();
    }
}
