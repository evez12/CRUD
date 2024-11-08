package com.huseynov.crud.controller;

import com.huseynov.crud.entity.Employee;
import com.huseynov.crud.service.EmployeeService;
import org.springframework.boot.Banner;
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
        return "employees/employee-add-update-form";
    }

    @PostMapping("/update")
    public String updateEmployeeForm(@RequestParam("employeeId") int id, Model model) {
        model.addAttribute("myEmployee", employeeService.findById(id));
        return "employees/employee-add-update-form";
    }

    @PostMapping("/save")
    public String addEmployee(@ModelAttribute("myEmployee") Employee theEmployee) {
        employeeService.save(theEmployee);
        return "redirect:/employees/list";
    }

    // version 1: employee delete
    @PostMapping("/delete-form")
    public String deleteEmployee(@RequestParam("employeeId") int id, Model model) {
        model.addAttribute("deletedEmployee", employeeService.findById(id));
        return "/employees/employee-delete-form";
    }

    @PostMapping("/delete")
    public String deleteEmployee(@ModelAttribute("deletedEmployee") Employee theEmployee) {
        employeeService.deleteById(theEmployee.getId());
        return "redirect:/employees/list";
    }

    // version 2: employee delete
    @GetMapping("/delete")public String deleteEmployee(@RequestParam("employeeId") int id){
        employeeService.deleteById(id);
        return "redirect:/employees/list";
    }
}
