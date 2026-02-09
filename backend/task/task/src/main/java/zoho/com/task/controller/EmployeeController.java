package zoho.com.task.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import zoho.com.task.model.Employee;
import zoho.com.task.repository.EmployeeRepository;
import zoho.com.task.service.PermissionService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepo;

    @Autowired
    PermissionService permissionService;

    @GetMapping("/{roleId}")
    public List<Map<String,Object>> getEmployees(@PathVariable Long roleId){

        List<Employee> list = employeeRepo.findAll();

        List<String> allowedFields =
                permissionService.getViewableFields(roleId,"employee");

        return list.stream().map(emp -> {

            Map<String,Object> map = new HashMap<>();

            if(allowedFields.contains("name"))
                map.put("name",emp.getName());

            if(allowedFields.contains("email"))
                map.put("email",emp.getEmail());

            if(allowedFields.contains("salary"))
                map.put("salary",emp.getSalary());

            return map;

        }).toList();
    }
}
