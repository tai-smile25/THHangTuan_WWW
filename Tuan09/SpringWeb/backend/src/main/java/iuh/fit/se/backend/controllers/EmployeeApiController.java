package iuh.fit.se.backend.controllers;

import iuh.fit.se.backend.entities.Employee;
import iuh.fit.se.backend.services.EmployeeService;
import iuh.fit.se.backend.utils.ApiResponse;
import iuh.fit.se.backend.utils.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class EmployeeApiController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<ApiResponse> getAllEmployees(
            @RequestParam(required = false) String keyword) {

        if (keyword != null && !keyword.isEmpty()) {
            List<Employee> employees = employeeService.search(keyword);
            return ResponseEntity.ok(ApiResponse.success(employees));
        }

        List<Employee> employees = employeeService.findAll();
        return ResponseEntity.ok(ApiResponse.success(employees));
    }

    @GetMapping("/employeesHasPage")
    public ResponseEntity<PageResponse<Employee>> getAllEmployeesWithPaging(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id,asc") String sort) {

        String[] sortParams = sort.split(",");
        Sort.Direction direction = sortParams[1].equalsIgnoreCase("desc")
                ? Sort.Direction.DESC : Sort.Direction.ASC;

        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(direction, sortParams[0]));
        Page<Employee> employeePage = employeeService.findAllWithPaging(pageRequest);

        PageResponse<Employee> response = new PageResponse<>();
        response.setContent(employeePage.getContent());
        response.setPageNumber(employeePage.getNumber());
        response.setPageSize(employeePage.getSize());
        response.setTotalElements(employeePage.getTotalElements());
        response.setTotalPages(employeePage.getTotalPages());
        response.setLast(employeePage.isLast());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<ApiResponse> getEmployeeById(@PathVariable int id) {
        Employee employee = employeeService.findById(id);
        if (employee != null) {
            return ResponseEntity.ok(ApiResponse.success(employee));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ApiResponse.error("Employee not found with id: " + id));
    }

    @PostMapping("/employees")
    public ResponseEntity<ApiResponse> createEmployee(@RequestBody Employee employee) {
        try {
            Employee saved = employeeService.save(employee);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(ApiResponse.success(saved));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ApiResponse.error(e.getMessage()));
        }
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<ApiResponse> updateEmployee(
            @PathVariable int id,
            @RequestBody Employee employee) {

        employee.setId(id);
        Employee updated = employeeService.update(employee);

        if (updated != null) {
            return ResponseEntity.ok(ApiResponse.success(updated));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ApiResponse.error("Employee not found with id: " + id));
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<ApiResponse> deleteEmployee(@PathVariable int id) {
        try {
            employeeService.delete(id);
            return ResponseEntity.ok(ApiResponse.success("Employee deleted successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error(e.getMessage()));
        }
    }
}