package com.luv2code.democrudproject.rest;

import com.luv2code.democrudproject.dao.EmployeeDAO;
import com.luv2code.democrudproject.entity.Employee;
import com.luv2code.democrudproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;
@Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee (@PathVariable int employeeId){
    Employee theEmployee=employeeService.findbyId(employeeId);
        return theEmployee;
    }

    //add a new employee we are using the post mapping
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){

            employee.setId(0);
            Employee dbEmployee=employeeService.save(employee);
            return dbEmployee;

    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
    Employee tempEmployee=employeeService.findbyId(employeeId);

    if(tempEmployee==null){
        throw  new RuntimeException("Employee ID not found "+employeeId);
    }
    employeeService.deletebyId(employeeId);
    return "deleted employee id"+employeeId;
    }
}
