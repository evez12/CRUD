package com.huseynov.crud.controller;

import com.huseynov.crud.entity.Employee;
import com.huseynov.crud.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {


    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel) {
        List<Employee> employees = employeeService.findAllByOrderByNameAsc();
        theModel.addAttribute("myEmployees", employees);
        return "employees/list-employees";
    }

    @GetMapping("/add")
    public String addEmployee(Model theModel) {
        theModel.addAttribute("myEmployee", new Employee());
        return "employees/add-employee-form";
    }

    @PostMapping("/save")
    public String addEmployee(@ModelAttribute("myEmployee") Employee theEmployee) {
        employeeService.save(theEmployee);
        return "redirect:/employees/list";
    }

    @GetMapping("/update")
    public String updateEmployeeForm(@RequestParam("employeeId") int id, Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        return "employees/update-form";
    }

    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute("employee") Employee updateEmployee) {
        employeeService.update(updateEmployee);
        return "redirect:/employees/list";
    }



}
