package br.com.books.favorite.repository;


import br.com.books.favorite.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.redis.core.RedisHash;

@RedisHash
public interface BookRepository extends MongoRepository<Book, String> {
    Book findByIsbn(String isbn);
}
