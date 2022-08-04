package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.domain.exception.NotFoundException;
import ru.netology.repository.CartRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {
    private CartRepository repository = new CartRepository();
    private ProductManager manager = new ProductManager(repository);

    Product product1 = new Book(1, "AnnaKarenina", 1000, "LevTolstoy");
    Product product2 = new Book(2,"RuslanAndLudmila",1100,"AlexanderPushkin");
    Product product3 = new Book(3,"FatherAndSons",1200, "IvanTurgenev");
    Product product4 = new Book(4,"Poems",1300,"AlexanderPushkin");
    Product product5 = new Smartphone(5,"Iphone",60_000,"Apple");
    Product product6 = new Smartphone(6,"Samsung",70_000,"Samsung");
    Product product7 = new Smartphone(7,"Redmi",20_000,"Xiaomi");
    Product product8 = new Smartphone(8,"Nokia",5_000,"Nokia");

    @BeforeEach
    public void addProducts() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
        manager.add(product6);
        manager.add(product7);
        manager.add(product8);
    }

    @Test
    public void searchByMakerBook() {
        Product[] actual = manager.searchBy("AnnaKarenina");
        Product[] expected = {product1};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByMakerSmartphone() {
        Product[] actual = manager.searchBy("Iphone");
        Product[] expected = {product5};
        assertArrayEquals(expected,actual);
    }

    @Test
    public void searchByBookAuthor() {
        Product[] actual = manager.searchBy("AlexanderPushkin");
        Product[] expected = {product2, product4};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchBySmartphoneManufacturer() {
        Product[] actual = manager.searchBy("Nokia");
        Product[] expected = {product8};
        assertArrayEquals(expected,actual);
    }

    @Test
    public void removalId() {
        repository.removeById(5);
        Product[] actual = repository.findAll();
        Product[] expected = {product1,product2,product3,product4,product6,product7,product8};
        assertArrayEquals(expected,actual);

    }

    @Test
    public void searchByInvalidMaker() {
        Product[] actual = manager.searchBy("One");
        Product[] expected = {};
        assertArrayEquals(expected,actual);
    }

    @Test
    public void searchByInvalidAuthor() {
        Product[] actual = manager.searchBy("Two");
        Product[] expected = {};
        assertArrayEquals(expected,actual);
    }

    @Test // Тест сохранить и найти все
    public void testSaveAndFindAll() {
        assertEquals(repository.findAll().length, 8);
    }

    @Test
    void shouldShowIfIdNotExist () {
        assertThrows(NotFoundException.class, ()-> repository.removeById(11));
    }

}