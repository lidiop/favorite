package br.com.books.favorite.repository;

import br.com.books.favorite.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
    User findByEmailAndPassword(String email, String password);
}
