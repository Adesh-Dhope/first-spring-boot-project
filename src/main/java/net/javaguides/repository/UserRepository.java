package net.javaguides.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import net.javaguides.model.User;

public interface UserRepository extends MongoRepository<User, String> {
}
