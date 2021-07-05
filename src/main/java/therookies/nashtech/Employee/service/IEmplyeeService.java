package therookies.nashtech.Employee.service;

import therookies.nashtech.Employee.entity.EmployeeEntity;

import java.util.List;
import java.util.Map;

public interface IEmplyeeService {
    EmployeeEntity save(EmployeeEntity employeeEntity);
    EmployeeEntity getOneById(Long id);
    List <EmployeeEntity> getAll();
    Map<String,String> deleteEmployee(Long id);

}
