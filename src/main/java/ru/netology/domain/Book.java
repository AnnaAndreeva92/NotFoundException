package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)

public class Book extends Product {
    private String author;

    public Book(int id, String title, int price, String author) {
        super(id, title, price);
        this.author = author;
    }
    @Override
    public boolean matches(String search ) {
        return super.matches(search) || author.equals(search);
    }
}