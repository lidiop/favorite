package br.com.books.favorite.service;

import br.com.books.favorite.entity.Book;
import br.com.books.favorite.repository.BookRepository;
import io.netty.util.internal.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@Component
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    @Qualifier("bookRestTemplate")
    private RestTemplate restTemplate;

    @Value("${app.url.isbn}")
    private String urlIsbn;

    @Cacheable(value = "books", key = "#isbn")
    public Book findById(String isbn) throws URISyntaxException {
        Book book1 = bookRepository.findByIsbn(isbn);
        if (!ObjectUtils.isEmpty(book1) ){
            return book1;
        }else{
            URI uri = new URI(urlIsbn);
            ResponseEntity<Book> bookEntity = restTemplate.getForEntity(uri + isbn, Book.class);
            Book book = bookEntity.getBody();
            return bookRepository.save(book);
        }
    }
}
