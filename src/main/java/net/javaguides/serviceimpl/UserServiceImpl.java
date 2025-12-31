package net.javaguides.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.model.User;
import net.javaguides.repository.UserRepository;
import net.javaguides.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
