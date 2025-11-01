package iuh.fit.se.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "redirect:/employees";
    }

    @GetMapping("/home")
    public String homePage() {
        return "redirect:/employees";
    }
}
