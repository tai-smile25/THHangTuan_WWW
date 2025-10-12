package iuh.fit.se.bai02;

import entities.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAnotation {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        Employee employee = (Employee) context.getBean("employeeBean");
        System.out.println("Employee ID: " + employee.getId());
        System.out.println("Employee Name: " + employee.getName());
        System.out.println("Employee Address: " + employee.getAddress().getCity() + ", "
                + employee.getAddress().getState() + ", " + employee.getAddress().getCountry());

    }
}
