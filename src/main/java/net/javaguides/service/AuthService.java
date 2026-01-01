package net.javaguides.service;

import net.javaguides.dto.LoginRequest;
import net.javaguides.dto.RegisterRequest;
import net.javaguides.dto.EmployeeResponse;

public interface AuthService {

	EmployeeResponse  register(RegisterRequest request);

	EmployeeResponse  login(LoginRequest request);
}

