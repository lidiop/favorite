package br.com.books.favorite.service;

import br.com.books.favorite.entity.User;
import br.com.books.favorite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Cacheable("users")
    public User authenticate(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
}