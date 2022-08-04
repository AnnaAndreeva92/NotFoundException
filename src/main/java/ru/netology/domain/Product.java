package ru.netology.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Product {
    private int id;
    private String title;
    private int price;

    public boolean matches(String search) {
        return title.equals(search);
    }
}

