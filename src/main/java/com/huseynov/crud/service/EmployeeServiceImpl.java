package com.huseynov.crud.service;

import com.huseynov.crud.dao.EmployeeDAO;
import com.huseynov.crud.entity.Employee;
import com.huseynov.crud.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
        Employee employee = employeeDAO.findById(id);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee not found id: " + id);
        }

        return employeeDAO.findById(id);
    }

    @Transactional // reason: we shall change in the database
    @Override
    public Employee save(Employee employee) {
        employee.setId(0); // create new employee

        if (employee.getName() == null || employee.getName().isEmpty() || employee.getSurname() == null || employee.getSurname().isEmpty() || employee.getEmail() == null || employee.getEmail().isEmpty()) {
            throw new RuntimeException("Employee name,surname or email is null or empty");
        }

        return employeeDAO.save(employee);
    }

    @Transactional
    @Override
    public Employee update(Employee employee) {

        if (employee.getName() == null || employee.getName().isEmpty() || employee.getSurname() == null || employee.getSurname().isEmpty() || employee.getEmail() == null || employee.getEmail().isEmpty()) {
            throw new RuntimeException("Employee name,surname or email is null or empty");
        }
        return employeeDAO.save(employee);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        Employee employee = employeeDAO.findById(id);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee not found id: " + id);
        }
        employeeDAO.deleteById(id);
    }


}
