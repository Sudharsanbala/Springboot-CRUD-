package com.luv2code.democrudproject.dao;

import com.luv2code.democrudproject.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOImplementation implements EmployeeDAO{

    //define fields for entity manager
    private EntityManager entitymanager;

    //setup constructor injection
    public EmployeeDAOImplementation(EntityManager entitymanager){
        this.entitymanager=entitymanager;
    }
    @Override
    public List<Employee> findAll() {
        //create the query
        TypedQuery<Employee> theQuery=entitymanager.createQuery("from Employee",Employee.class);
        //execute query and return the list
        List<Employee> employees=theQuery.getResultList();

        return employees;
    }

    @Override
    public Employee findbyId(int Id) {
        //find the employee
        Employee theEmployee=entitymanager.find(Employee.class,Id);
        return theEmployee;
    }

    @Override
    public Employee save(Employee employee) {
        Employee dbEmployee=entitymanager.merge(employee);
        return dbEmployee;
    }

    @Override
    public void deletebyId(int Id) {
        //find the employee
        Employee theEmployee=entitymanager.find(Employee.class,Id);
        entitymanager.remove(theEmployee);

    }
}
