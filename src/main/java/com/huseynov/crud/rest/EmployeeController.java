package com.huseynov.crud.rest;

import com.huseynov.crud.entity.Employee;
import com.huseynov.crud.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("employee")
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("employee/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {

        return employeeService.findById(employeeId);
    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }

    @DeleteMapping("/employee/{employeeId}")
    public String  deleteEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);
        employeeService.deleteById(employeeId);
        return "Deleted employee id: " + employee.getId();

    }

    @DeleteMapping("/employee")
    public void deleteEmployee(@RequestBody Employee employee) {
        employeeService.deleteById(employee.getId());
    }

}
