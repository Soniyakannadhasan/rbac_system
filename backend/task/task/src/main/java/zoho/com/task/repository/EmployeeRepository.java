package zoho.com.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zoho.com.task.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{}
