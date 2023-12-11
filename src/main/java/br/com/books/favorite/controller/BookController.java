package br.com.books.favorite.controller;

import br.com.books.favorite.entity.Book;
import br.com.books.favorite.repository.BookRepository;
import br.com.books.favorite.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/{isbn}")
    public ResponseEntity<Book> findBook(@PathVariable String isbn) throws URISyntaxException {
        return ResponseEntity.ok(bookService.findById(isbn));
    }

    @GetMapping
    public ResponseEntity<List<Book>> list(){
        return ResponseEntity.ok(bookRepository.findAll());
    }
}