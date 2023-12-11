package br.com.books.favorite.controller;

import br.com.books.favorite.entity.User;
import br.com.books.favorite.repository.FavoriteRepository;
import br.com.books.favorite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FavoriteRepository favoriteRepository;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) throws URISyntaxException {
        user.setCreatedDate(LocalDateTime.now());
        User userInserted = userRepository.insert(user);
        return ResponseEntity.created(new URI("http://locahost:8080/api/users/" + userInserted.getEmail())).body(userInserted);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        userRepository.deleteById(id);
        favoriteRepository.deleteAllByUserId(id);
        return ResponseEntity.ok("Usuario e favoritos removidos");
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user) {
        Optional<User> byId = userRepository.findById(user.getId());
        if (byId.isPresent()) {
            user.setCreatedDate(byId.get().getCreatedDate());
        } else {
            user.setCreatedDate(LocalDateTime.now());
        }
        return ResponseEntity.ok(userRepository.save(user));
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> findByEmail(@PathVariable String email) {
        User user = userRepository.findByEmail(email);
        if (ObjectUtils.isEmpty(user)) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> listAll() {
        return ResponseEntity.ok(userRepository.findAll());
    }
}