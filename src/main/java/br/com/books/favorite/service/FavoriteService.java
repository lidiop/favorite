package br.com.books.favorite.service;

import br.com.books.favorite.entity.Book;
import br.com.books.favorite.entity.Favorite;
import br.com.books.favorite.entity.User;
import br.com.books.favorite.exception.UserNotFoundException;
import br.com.books.favorite.repository.FavoriteRepository;
import br.com.books.favorite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class FavoriteService {

    @Autowired
    private BookService bookService;
    @Autowired
    private FavoriteRepository favoriteRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Favorite> findAllByUserId(String id) {
        return favoriteRepository.findAllByUserId(id);
    }

    public List<Book> findAllByIsbn(List<String> isbnIds) {
        List<Book> list = new ArrayList<>();
        for (String isbn : isbnIds) {
            try {
                list.add(bookService.findById(isbn));
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
        return list;
    }

    public Favorite save(Favorite favorite) throws UserNotFoundException {
        Optional<User> user =  userRepository.findById(favorite.getUserId());
        if(user.isEmpty() ) throw new UserNotFoundException("User Not Found");
        return favoriteRepository.save(favorite);
    }

    public void deleteByUserIdAndIsbn(Favorite favorite) {
        favoriteRepository.deleteByUserIdAndIsbn(favorite.getUserId(), favorite.getIsbn());
    }
}