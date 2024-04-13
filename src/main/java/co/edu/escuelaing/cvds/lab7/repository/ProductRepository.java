package co.edu.escuelaing.cvds.lab7.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.escuelaing.cvds.lab7.model.Employee;

public interface ProductRepository extends JpaRepository<Employee, String> {
    public List<Employee> findById(Integer id);
}

