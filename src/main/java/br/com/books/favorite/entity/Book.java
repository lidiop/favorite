package br.com.books.favorite.entity;

import br.com.books.favorite.converter.StringListConverter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Convert;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Document(collection = "books")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book implements Serializable {
    @Id
    private String id;
    @Indexed(unique = true)
    private String isbn;
    private String title;
    private String subtitle;
    @Convert(converter = StringListConverter.class)
    private List<String> authors = new ArrayList<>();
    private String publisher;
    private String synopsis;
    private String year;
    private String format;
    private String page_count;
    @Convert(converter = StringListConverter.class)
    private List<String> subjects = new ArrayList<>();
    private String location;
    private String retail_price;
    private String cover_url;
    private String provider;
}