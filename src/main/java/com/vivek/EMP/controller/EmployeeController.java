package com.vivek.EMP.controller;

import com.vivek.EMP.model.Employee;
import com.vivek.EMP.repository.EmployeeRepo;
import com.vivek.EMP.serviceIMPL.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl empService;
    @GetMapping("/home")
    public String homePage(){
        return "Welcome to Employee Management";
    }
    @PostMapping("/addEmp")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee emp = empService.addEmployee(employee);
        return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
    }
    @DeleteMapping("/removeEmp/{id}")
    public ResponseEntity<String> removeEmployee(@PathVariable int id){
        empService.removeEmployee(id);
        return new ResponseEntity<String>("Removed Successfully", HttpStatus.ACCEPTED);
    }
    @GetMapping("/findEmp/{id}")
    public ResponseEntity<Optional<Employee>> findEmpById(@PathVariable int id){
        Optional<Employee> emps = empService.findEmpById(id);
        return new ResponseEntity<Optional<Employee>>(emps, HttpStatus.ACCEPTED);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> listOfEmployee(){
        List<Employee> lEmp = empService.getAllEmployee();
        return new ResponseEntity<List<Employee>>(lEmp, HttpStatus.ACCEPTED);
    }
    @PutMapping("/updateEmp/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable int id, @RequestBody Employee employee){
        empService.updateEmployee(id, employee);
        return new ResponseEntity<String>("Updated", HttpStatus.ACCEPTED);
    }

}
