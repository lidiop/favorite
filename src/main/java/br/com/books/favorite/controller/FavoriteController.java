package br.com.books.favorite.controller;

import br.com.books.favorite.entity.Book;
import br.com.books.favorite.entity.Favorite;
import br.com.books.favorite.entity.User;
import br.com.books.favorite.exception.UserNotFoundException;
import br.com.books.favorite.repository.UserRepository;
import br.com.books.favorite.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/favorite")
public class FavoriteController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FavoriteService favoriteService;

    @GetMapping("/users/{email}")
    public ResponseEntity<List<Book>> findByEmail(@PathVariable String email) {
        User user = userRepository.findByEmail(email);
        List<Favorite> favoriteList = favoriteService.findAllByUserId(user.getId());
        List<String> isbnIds = favoriteList.stream().map(Favorite::getIsbn).collect(Collectors.toList());
        List<Book> allById = favoriteService.findAllByIsbn(isbnIds);
        return ResponseEntity.ok(allById);
    }

    @PostMapping
    public ResponseEntity<Favorite> save(@RequestBody Favorite favorite) throws UserNotFoundException {
        Favorite favoriteSaved = favoriteService.save(favorite);
        return ResponseEntity.ok(favoriteSaved);
    }

    @DeleteMapping
    public ResponseEntity<String> remove(@RequestBody Favorite favorite) {
        favoriteService.deleteByUserIdAndIsbn(favorite);
        return ResponseEntity.ok("Favorito removido");
    }
}