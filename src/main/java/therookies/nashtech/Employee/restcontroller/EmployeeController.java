package therookies.nashtech.Employee.restcontroller;

import therookies.nashtech.Employee.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import therookies.nashtech.Employee.service.impl.EmployeeService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping(value ="/employee")
    EmployeeEntity createEmployee(@RequestBody EmployeeEntity employee) {
        return employeeService.save(employee);
    }
    @PutMapping(value= "/employee/{id}")
    EmployeeEntity updateEmployee(@RequestBody EmployeeEntity employee, @PathVariable("id") Long id) {
        employee.setId(id);
        return employeeService.save(employee);
    }
    @GetMapping(value= "/employee/{id}")
    EmployeeEntity getEmployeeById(@PathVariable("id") Long id) {
        return employeeService.getOneById(id);
    }
    @GetMapping(value = "/employee")
    List<EmployeeEntity> getAllEmployee() {
        return employeeService.getAll();
    }
    @DeleteMapping(value="/employee/{id}")
    Map<String,String> deleteEmployee(@PathVariable("id") Long id) {
        return employeeService.deleteEmployee(id);
    }

}
