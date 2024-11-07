package com.huseynov.crud.service;

import com.huseynov.crud.dao.EmployeeRepository;
import com.huseynov.crud.entity.Employee;
import com.huseynov.crud.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findAllByOrderByNameAsc() {
        return employeeRepository.findAllByOrderByNameAsc();
    }

    @Override
    public Employee findById(int id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee not found id: " + id);
        }
        return employee;
    }

    @Override
    public void save(Employee employee) {
        if (    employee.getName() == null || employee.getName().trim().isEmpty() ||
                employee.getSurname() == null || employee.getSurname().trim().isEmpty() ||
                employee.getEmail() == null || employee.getEmail().trim().isEmpty()) {
            throw new RuntimeException("Employee name,surname or email is null or empty");
        }

        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee not found id: " + id);
        } else {
            employeeRepository.deleteById(id);
        }
    }


}
