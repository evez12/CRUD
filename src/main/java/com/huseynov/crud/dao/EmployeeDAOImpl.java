package com.huseynov.crud.dao;

import com.huseynov.crud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Deprecated
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final EntityManager em;

    @Autowired
    public EmployeeDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> query = em.createQuery("from Employee", Employee.class);

        // execute query and get result list, then return
        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        return em.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee) {
        return em.merge(employee);
    }

    @Override
    public void deleteById(int id) {
        Employee employee = em.find(Employee.class, id);
        em.remove(employee);
    }

}
