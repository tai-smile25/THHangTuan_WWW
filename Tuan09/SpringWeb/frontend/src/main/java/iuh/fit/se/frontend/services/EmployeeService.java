package iuh.fit.se.frontend.services;

import iuh.fit.se.frontend.entities.Employee;
import iuh.fit.se.frontend.utils.ApiResponse;
import iuh.fit.se.frontend.utils.PageResponse;

public interface EmployeeService {

    public ApiResponse findById(int id);

    public ApiResponse findAll();

    public PageResponse<Employee> findAllWithPaging(int page, int size, String sort);

    public ApiResponse save(Employee employee);

    public ApiResponse update(int id, Employee employee);

    public ApiResponse delete(int id);

    public ApiResponse search(String keyword);
}