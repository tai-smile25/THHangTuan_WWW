package iuh.fit.se.backend.services;

import iuh.fit.se.backend.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Page<Employee> findAllWithPaging(Pageable pageable);
    Employee findById(int id);
    Employee save(Employee employee);
    Employee update(Employee employee);
    void delete(int id);
    List<Employee> search(String keyword);
}