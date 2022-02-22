package ru.netology;

import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.domain.Book;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductManagerTest {

    @Test
    void TestMetodMatches() {
        ProductManager productManager = new ProductManager();
        Book book2 = new Book(3, "3", 200, "string");
        ProductRepository repository = new ProductRepository();
        repository.add(book2);
        boolean status = productManager.matches(book2, "3");
        assertTrue(status);

    }

    @Test
    void TestSearchByNameElement() {
        Book book = new Book(1, "1", 200, "string1");
        Book book1 = new Book(2, "2", 200, "string");
        Book book2 = new Book(3, "3", 200, "string");
        Product produkt1 = new Product(5, "6", 200);
        book.hashCode();

        ProductRepository repository = new ProductRepository();
        repository.add(book);
        repository.add(book1);
        repository.add(book2);
        repository.add(produkt1);
        ProductManager productManager = new ProductManager(repository);
        Product[] a = productManager.searchBy("6");
        produkt1.hashCode();
        assertEquals(a[0], produkt1);
    }

    @Test
    void TestSearchByNameElementNull() {
        Book book = new Book(1, "1", 200, "string1");
        Book book1 = new Book(2, "2", 200, "string");
        Book book2 = new Book(3, "3", 200, "string");
        Product produkt1 = new Product(5, "6", 200);
        ProductRepository repository = new ProductRepository();
        repository.add(book);
        repository.add(book1);
        repository.add(book2);
        repository.add(produkt1);
        ProductManager productManager = new ProductManager(repository);
        assertNull(productManager.searchBy("7"));
    }

    @Test
    void TestSearchByNameElementZero() {
        ProductRepository repository = new ProductRepository();
        ProductManager productManager = new ProductManager(repository);
        assertNull(productManager.searchBy("0"));
    }


    @Test
    void TestMetodObjProduct() {
        Product product = new Product(2, "uname", 200);
        Product product1 = new Product(2, "uname", 200);
        assertEquals(product, product1);
    }

    @Test
    void TestMetodObjBook() {
        Book product = new Book(2, "uname", 200, "user");
        Book product1 = new Book(2, "uname", 200, "user");
        assertEquals(product, product1);
    }

    @Test
    void TestMetodObjBook2() {
        Product product = new Product(2, "uname", 200);
        boolean bool = (product instanceof Book);
        assertFalse(bool);


    }

    @Test
    void TestMetodObjSmartphone() {
        Smartphone product = new Smartphone(2, "uname", 200, "user");
        Smartphone product1 = new Smartphone(2, "uname", 200, "user");
        assertEquals(product, product1);
    }

    @Test
    void TestTwoMore() {
        Book book = new Book(1, "2", 200, "string");
        Book book1 = new Book(4, "2", 200, "string");
        Book book2 = new Book(4, "3", 200, "string");
        Smartphone smartphone = new Smartphone(4, "5", 210, "str");
        ProductRepository repository = new ProductRepository();
        ProductManager productManager = new ProductManager(repository);
        productManager.add(book);
        productManager.add(book1);
        productManager.add(book2);
        productManager.add(smartphone);
        Product[] products = new Product[]{book, book1};
        assertArrayEquals(products, productManager.searchBy("2"));
    }

    @Test
    public void TestAddRepository() {
        Book book = new Book(1, "2", 200, "string");
        Book book1 = new Book(2, "2", 200, "string");
        Book book2 = new Book(3, "2", 200, "string");
        Smartphone smartphone = new Smartphone(4, "5", 210, "str");
        ProductRepository repository = new ProductRepository();
        repository.add(book);
        repository.add(book1);
        repository.add(book2);
        repository.add(smartphone);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{book, book1, book2, smartphone};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void TestFindSmartphone() {
        Book book = new Book(1, "2", 200, "string");
        Book book1 = new Book(2, "2", 200, "string");
        Book book2 = new Book(3, "2", 200, "string");
        Smartphone smartphone = new Smartphone(4, "5", 210, "str");
        ProductRepository repository = new ProductRepository();
        repository.add(book);
        repository.add(book1);
        repository.add(book2);
        repository.add(smartphone);
        assertEquals(smartphone, repository.findByld(4));

    }

    @Test
    public void TestFindBook() {
        Book book = new Book(1, "2", 200, "string");
        Book book1 = new Book(2, "2", 200, "string");
        Book book2 = new Book(3, "2", 200, "string");
        Smartphone smartphone = new Smartphone(4, "5", 210, "str");
        ProductRepository repository = new ProductRepository();
        repository.add(book);
        repository.add(book1);
        repository.add(book2);
        repository.add(smartphone);
        assertEquals(book2, repository.findByld(3));

    }

    @Test
    public void TestDeleteElementRepository() {
        Book book = new Book(1, "2", 200, "string");
        Book book1 = new Book(2, "2", 200, "string");
        Book book2 = new Book(3, "2", 200, "string");
        Smartphone smartphone = new Smartphone(4, "5", 210, "str");
        ProductRepository repository = new ProductRepository();
        repository.add(book);
        repository.add(book1);
        repository.add(book2);
        repository.add(smartphone);
        repository.removeByld(2);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{book, book2, smartphone};
        assertArrayEquals(expected, actual);
    }


    @Test
    public void TestConstNoParametrBook() {
        Book book = new Book();
        Book book1 = new Book(2, "2", 200, "string");
        Book book2 = new Book(3, "2", 200, "string");
        Smartphone smartphone = new Smartphone(4, "5", 210, "str");
        ProductRepository repository = new ProductRepository();
        book.setId(1);
        book.setName("2");
        book.setPrice(200);
        book.setAuthor("TEXT");
        repository.add(book);
        repository.add(book1);
        repository.add(book2);
        repository.add(smartphone);
        repository.removeByld(2);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{book, book2, smartphone};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void TestFindNameElementAndConstrNoParamSmartphone() {
        Smartphone smartphone = new Smartphone(4, "5", 210, "str");
        Smartphone smartphone1 = new Smartphone();
        ProductRepository repository = new ProductRepository();
        smartphone1.setId(1);
        smartphone1.setName("2");
        smartphone1.setPrice(200);
        smartphone1.setManufacturer("TEXT");
        repository.add(smartphone);
        repository.add(smartphone1);
        assertEquals("TEXT", smartphone1.getManufacturer());
    }

    @Test
    public void TestGetPriceSmartphone() {
        Smartphone smartphone = new Smartphone(4, "5", 210, "str");
        Smartphone smartphone1 = new Smartphone();
        ProductRepository repository = new ProductRepository();
        smartphone1.setId(1);
        smartphone1.setName("2");
        smartphone1.setPrice(200);
        smartphone1.setManufacturer("TEXT");
        repository.add(smartphone);
        repository.add(smartphone1);
        assertEquals(200, smartphone1.getPrice());
    }

    @Test
    public void TestGetNameSmartphone() {

        Smartphone smartphone1 = new Smartphone();
        ProductRepository repository = new ProductRepository();
        smartphone1.setId(1);
        smartphone1.setName("2");
        smartphone1.setPrice(200);
        smartphone1.hashCode();
        smartphone1.setManufacturer("TEXT");
        repository.add(smartphone1);
        assertEquals("2", smartphone1.getName());
    }

    @Test
    public void RepositoryFindByldNullTest() {
        Book book1 = new Book(2, "2", 200, "string");
        Book book2 = new Book(3, "2", 200, "string");
        ProductRepository repository = new ProductRepository();
        repository.add(book1);
        repository.add(book2);
        assertNull(repository.findByld(0));
    }
}
