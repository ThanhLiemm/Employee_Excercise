package therookies.nashtech.Employee.service.impl;

import therookies.nashtech.Employee.entity.EmployeeEntity;
import therookies.nashtech.Employee.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import therookies.nashtech.Employee.repository.EmployeeRepository;
import therookies.nashtech.Employee.service.IEmplyeeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService implements IEmplyeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public EmployeeEntity save(EmployeeEntity employeeEntity) {
        EmployeeEntity employee = new EmployeeEntity();
        if(employeeEntity.getId()==null) {
            employee = employeeRepository.save(employeeEntity);
            return employee;
        }

        employee = employeeRepository.findById(employeeEntity.getId())
                            .map(emp ->{
                                emp.setName(employeeEntity.getName());
                                emp.setPosition(employeeEntity.getPosition());
                                return employeeRepository.save(emp);
                            })
                            .orElseGet(()->{
                                return employeeRepository.save(employeeEntity);
                            });
        return employee;
    }

    @Override
    public EmployeeEntity getOneById(Long id) {
        EmployeeEntity employeeEntity;
        employeeEntity = employeeRepository.findById(id)
                            .map(empl -> {return empl;})
                            .orElseGet(()->{return null;});
        if(employeeEntity==null) throw new IdNotFoundException("Can not found employee id = "+id);
        else return employeeEntity;
    }

    @Override
    public List<EmployeeEntity> getAll() {
        List<EmployeeEntity> employeeEntities=employeeRepository.findAll();
        return employeeEntities;
    }

    @Override
    public Map<String, String> deleteEmployee(Long id) {
        EmployeeEntity employee;
        employee = employeeRepository.findById(id)
                .map(empl -> {return empl;})
                .orElseGet(()->{return null;});
        if(employee==null) throw new IdNotFoundException("Can not found employee id = "+id);
        employeeRepository.deleteById(id);
        Map<String,String> respone = new HashMap<>();
        respone.put("Status","Success");
        return respone;
    }
}
