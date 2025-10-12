package iuh.fit.se.bai02;

import entities.Address;
import entities.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Address address() {
        return new Address("Hanoi", "HN", "Vietnam");
    }

    @Bean
    public Employee employee() {
        return new Employee(1, "Nguyen Van A", address());
    }
}
