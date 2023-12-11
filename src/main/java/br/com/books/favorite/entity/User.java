package br.com.books.favorite.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "users")
@Getter
@Setter
@CompoundIndex(def = "{'email': 1}", unique = true)
public class User implements Serializable {
    @Id
    private String id;
    private String email;
    private String password;
    private LocalDateTime createdDate;
    private List<String> roles;
}
