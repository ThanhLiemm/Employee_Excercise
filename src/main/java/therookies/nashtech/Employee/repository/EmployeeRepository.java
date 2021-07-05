package therookies.nashtech.Employee.repository;

import therookies.nashtech.Employee.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity ,Long> {
}
