package com.huseynov.crud.dao;

import com.huseynov.crud.entity.Employee;

import java.util.List;

@Deprecated
public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);

}
