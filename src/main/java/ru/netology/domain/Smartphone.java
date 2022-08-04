package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)

public class Smartphone extends Product {
    private String manufacture;

    public Smartphone(int id, String title, int price, String manufacture) {
        super(id, title, price);
        this.manufacture = manufacture;
    }
    @Override
    public boolean matches(String search) {
        return super.matches(search);
    }
}