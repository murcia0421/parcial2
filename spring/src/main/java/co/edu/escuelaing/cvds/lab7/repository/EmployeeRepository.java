package co.edu.escuelaing.cvds.lab7.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.escuelaing.cvds.lab7.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    public List<Employee> findByEmployeeId(String employeeId);
}

