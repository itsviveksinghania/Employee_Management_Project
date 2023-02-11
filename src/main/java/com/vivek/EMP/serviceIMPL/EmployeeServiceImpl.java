package com.vivek.EMP.serviceIMPL;

import com.vivek.EMP.model.Employee;
import com.vivek.EMP.repository.EmployeeRepo;
import com.vivek.EMP.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public Employee addEmployee(Employee employee) {

        Employee emp = employeeRepo.save(employee);
        return emp;
    }

    @Override
    public String removeEmployee(int id) {
        employeeRepo.deleteById(id);
        return "Deleted Data Successfully";
    }

    @Override
    public Optional<Employee> findEmpById(int id) {
        Optional<Employee> emp = employeeRepo.findById(id);

        if(emp.isPresent()){
            return emp;
        }
        else {
            return null;
        }

    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> empList = employeeRepo.findAll();
        return empList;
    }

    @Override
    public String updateEmployee(int id, Employee employee) {
        Optional<Employee> emp = employeeRepo.findById(id);

        if(emp.isPresent()){
            Employee getEmp = employeeRepo.getReferenceById(id);
            getEmp.setName(employee.getName());
            getEmp.setAge(employee.getAge());
            getEmp.setState(employee.getState());
            getEmp.setType(employee.getType());
            getEmp.setSalary(employee.getSalary());

            employeeRepo.save(getEmp);

            return "Updated Successfully";
        }
        else {
            return "Employee Not Found";
        }

    }
}
