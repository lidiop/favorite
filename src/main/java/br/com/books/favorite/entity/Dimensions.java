package br.com.books.favorite.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Dimensions implements Serializable {
    private String width;
    private String height;
    private String unit;
}
