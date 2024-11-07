package com.huseynov.crud.service;

import com.huseynov.crud.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    List<Employee> findAllByOrderByNameAsc();

    Employee findById(int id);

    Employee save(Employee employee);

    Employee update(Employee employee);

    void deleteById(int id);

}
