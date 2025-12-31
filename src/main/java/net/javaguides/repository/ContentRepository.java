package net.javaguides.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import net.javaguides.model.Content;

public interface ContentRepository extends MongoRepository<Content, String> {
}
