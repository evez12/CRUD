package com.huseynov.crud.controller;

import com.huseynov.crud.entity.Employee;
import com.huseynov.crud.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {


    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/menu")
    public String getMenuPage(Model model) {
        return "menu";
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel) {
        List<Employee> employees = employeeService.findAll();
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


}
