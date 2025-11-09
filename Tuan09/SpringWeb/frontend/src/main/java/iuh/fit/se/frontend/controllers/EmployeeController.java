package iuh.fit.se.frontend.controllers;

import java.util.List;

import iuh.fit.se.frontend.utils.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import iuh.fit.se.frontend.entities.Employee;
import iuh.fit.se.frontend.services.EmployeeService;
import iuh.fit.se.frontend.utils.ApiResponse;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ModelAndView getList(ModelAndView model) {
        ApiResponse response = employeeService.findAll();

        List<Employee> employees = null;

        if (response != null && response.getErrors() == null) {
            employees = (List<Employee>) response.getData();
        }
        model.setViewName("employee-list");
        model.addObject("employees", employees);
        return model;
    }

    @GetMapping("/page/{pageNo}")
    public String getListHasPaging(Model model,
                                   @PathVariable int pageNo,
                                   @RequestParam(defaultValue = "10") int pageSize,
                                   @RequestParam(defaultValue = "id,asc") String sort) {
        PageResponse<Employee> pageResponse = employeeService.findAllWithPaging(pageNo - 1, pageSize, sort);
        model.addAttribute("employees", pageResponse.getContent());
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", pageResponse.getTotalPages());
        model.addAttribute("totalItems", pageResponse.getTotalElements());

        model.addAttribute("sort", sort);
        model.addAttribute("pageSize", pageSize);
        return "employee-list";
    }

    @GetMapping("/showForm")
    public ModelAndView showForm(ModelAndView model) {
        Employee employee = new Employee();
        model.setViewName("employee-form");
        model.addObject("employee", employee);
        return model;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute Employee employee) {

        ApiResponse response;
        if (employee.getId() == 0) {
            response = employeeService.save(employee);
        }
        else {
            response = employeeService.update(employee.getId(), employee);
        }

        if (response != null && response.getErrors() != null) {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("employee-form");
            modelAndView.addObject("errors", response.getErrors());
            return modelAndView;
        }
        else {
            return new ModelAndView("redirect:/employees");
        }
    }

    @GetMapping("/update")
    public ModelAndView update(@RequestParam("employeeId") int id, ModelAndView model) {
        ApiResponse response = employeeService.findById(id);
        Employee employee = new Employee();

        if (response != null && response.getErrors() == null) {
            employee = (Employee) response.getData();
        }
        else {
            model.addObject("error", "Can not find Employee with id: " + id);
        }

        model.addObject("employee", employee);
        model.setViewName("employee-form");

        return model;
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id) {
        employeeService.delete(id);
        return "redirect:/employees";
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam String keyword, ModelAndView model) {
        ApiResponse response = employeeService.search(keyword);

        List<Employee> employees = null;

        if (response != null && response.getErrors() == null) {
            employees = (List<Employee>) response.getData();
        }

        model.setViewName("employee-list");
        model.addObject("employees", employees);

        return model;
    }
}