package com.huseynov.crud.service;

import com.huseynov.crud.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    List<Employee> findAllByOrderByNameAsc();

    Employee findById(int id);

    void save(Employee employee);


    void deleteById(int id);

}
