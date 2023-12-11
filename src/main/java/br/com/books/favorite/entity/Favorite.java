package br.com.books.favorite.entity;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@Setter
@Document(collection = "favorite")
@CompoundIndex(def = "{'userId': 1, 'isbn': 1}", unique = true)
public class Favorite implements Serializable {
    @Id
    private String id;
    private String userId;
    private String isbn;
}