package net.javaguides.serviceimpl;

import net.javaguides.dto.EmployeeResponse;
import net.javaguides.dto.LoginRequest;
import net.javaguides.dto.RegisterRequest;
import net.javaguides.model.Employee;
import net.javaguides.repository.EmployeeRepository;
import net.javaguides.service.AuthService;
import net.javaguides.service.EmailService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final EmailService emailService;
    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(EmployeeRepository employeeRepository,
                           PasswordEncoder passwordEncoder,  EmailService emailService) {
        this.employeeRepository = employeeRepository;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
    }

    @Override
    public EmployeeResponse register(RegisterRequest request) {

        if (employeeRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        Employee user = new Employee();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole("L1");

        Employee savedUser = employeeRepository.save(user);
        
        emailService.sendEmployeeWelcomeMail(
                savedUser.getEmail(),
                savedUser.getName()
        );

        return mapToResponse(savedUser);
    }

    @Override
    public EmployeeResponse login(LoginRequest request) {

        Employee user = employeeRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        
        emailService.sendLoginSuccessMail(
                user.getEmail(),
                user.getName()
        );

        return mapToResponse(user);
    }

    private EmployeeResponse mapToResponse(Employee employee) {
        return new EmployeeResponse(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getRole()
        );
    }
}
