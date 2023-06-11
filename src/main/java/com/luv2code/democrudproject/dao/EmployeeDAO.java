package com.luv2code.democrudproject.dao;

import com.luv2code.democrudproject.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findbyId(int Id);

    Employee save(Employee employee);

    void deletebyId(int Id);
}
