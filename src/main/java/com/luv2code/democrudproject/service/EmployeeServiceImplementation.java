package com.luv2code.democrudproject.service;

import com.luv2code.democrudproject.dao.EmployeeDAO;
import com.luv2code.democrudproject.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImplementation implements EmployeeService{

    private EmployeeDAO employeeDAO;

@Autowired
    public EmployeeServiceImplementation(EmployeeDAO employeeDAO){
        this.employeeDAO=employeeDAO;
    }
    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findbyId(int Id) {
        return employeeDAO.findbyId(Id);
    }
@Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }
@Transactional
    @Override
    public void deletebyId(int Id) {
    employeeDAO.deletebyId(Id);



    }
}
