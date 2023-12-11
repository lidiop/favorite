package br.com.books.favorite.repository;

import br.com.books.favorite.entity.Favorite;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FavoriteRepository extends MongoRepository<Favorite, String> {
    List<Favorite> findAllByUserId(String userId);
    void deleteByUserIdAndIsbn(String userId, String isbn);
    void deleteAllByUserId(String userId);
}