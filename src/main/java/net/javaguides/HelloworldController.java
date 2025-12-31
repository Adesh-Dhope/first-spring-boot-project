package net.javaguides;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldController {
    @GetMapping("/test")
    public String testApi() {
        return "Spring Boot is running successfully!";
    }
}
