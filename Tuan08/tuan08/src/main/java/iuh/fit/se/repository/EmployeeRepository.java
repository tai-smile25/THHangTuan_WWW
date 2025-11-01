package iuh.fit.se.repository;

import iuh.fit.se.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Spring Data JPA sẽ tự động implement CRUD methods
}