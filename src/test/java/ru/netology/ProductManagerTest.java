package ru.netology;
/*
 * Это тест который просили в задании
 */

import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.domain.Book;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductManagerTest {

    Book book = new Book(1, "1", 200, "string1");
    Book book1 = new Book(2, "2", 200, "string");
    Book book2 = new Book(3, "3", 200, "string");
    Product produkt1 = new Product(5, "6", 200);
    Smartphone smartphone = new Smartphone(4, "5", 200, "main");
    ProductRepository repository = new ProductRepository();
    ProductManager productManager = new ProductManager(repository);

    @Test
    void testAddManagerAndNotFindElement() {
        productManager.add(book);
        productManager.add(book2);
        productManager.add(book1);
        productManager.add(smartphone);
        productManager.add(produkt1);
        Product[] expected=productManager.getResult();
        assertArrayEquals(expected, productManager.searchBy("0"));

    }

    @Test
    public void testDeleteElementRepository() {
        productManager.add(book);
        productManager.add(book2);
        productManager.add(book1);
        productManager.add(smartphone);
        repository.removeByld(2);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{book, book2, smartphone};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void repositoryFindByldNullTest() {

        productManager.add(book1);
        productManager.add(book2);
        assertEquals(null,repository.findByld(0));
    }

    @Test
    public void testFindBook() {
        productManager.add(book);
        productManager.add(book2);
        productManager.add(book1);
        productManager.add(smartphone);
        assertEquals(book2, repository.findByld(3));
    }

    @Test
    void testTwoMore() {
        book.setName("2");
        book1.setName("2");
        productManager.add(book);
        productManager.add(book1);
        productManager.add(book2);
        productManager.add(smartphone);
        Product[] products = new Product[]{book, book1};
        assertArrayEquals(products, productManager.searchBy("2"));
    }

}
