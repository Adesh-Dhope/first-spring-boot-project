package net.javaguides.service;


import java.util.List;
import net.javaguides.model.User;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUsers();
}
