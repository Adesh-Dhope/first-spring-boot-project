package net.javaguides.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import net.javaguides.model.Teacher;

public interface TeacherRepository extends MongoRepository<Teacher, Long> {
}

