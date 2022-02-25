package ru.netology;
/*
*Тут Хронятся тесты для покрытия 100% методов
* Не относится к заданию
*
 */




import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.domain.Book;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEtc {
    Book book = new Book(1, "1", 200, "string1");
    Book book1 = new Book(2, "2", 200, "string");
    Book book2 = new Book(3, "3", 200, "string");
    Product produkt1 = new Product(5, "6", 200);



    @Test
    void testMetodMatches() {
        ProductManager productManager = new ProductManager();
        ProductRepository repository = new ProductRepository();
        repository.add(book2);
        boolean status = productManager.matches(book2, "3");
        assertTrue(status);

    }

    @Test
    void testSearchByNameElement() {
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
    void testSearchByNameElementNull() {
        ProductRepository repository = new ProductRepository();
        repository.add(book);
        repository.add(book1);
        repository.add(book2);
        repository.add(produkt1);
        ProductManager productManager = new ProductManager(repository);
        assertNull(productManager.searchBy("7"));
    }

    @Test
    void testSearchByNameElementZero() {
        ProductRepository repository = new ProductRepository();
        ProductManager productManager = new ProductManager(repository);
        assertNull(productManager.searchBy("0"));
    }


    @Test
    void testMetodObjProduct() {
        Product product = new Product(2, "uname", 200);
        Product product1 = new Product(2, "uname", 200);
        assertEquals(product, product1);
    }

    @Test
    void testMetodObjBook() {
        Book product = new Book(2, "uname", 200, "user");
        Book product1 = new Book(2, "uname", 200, "user");
        assertEquals(product, product1);
    }

    @Test
    void testMetodObjBook2() {
        Product product = new Product(2, "uname", 200);
        boolean bool = (product instanceof Book);
        assertFalse(bool);


    }

    @Test
    void testMetodObjSmartphone() {
        Smartphone product = new Smartphone(2, "uname", 200, "user");
        Smartphone product1 = new Smartphone(2, "uname", 200, "user");
        assertEquals(product, product1);
    }

    @Test
    void testTwoMore() {
        ProductRepository repository = new ProductRepository();
        ProductManager productManager = new ProductManager(repository);
        book.setName("2");
        book1.setName("2");
        productManager.add(book);
        productManager.add(book1);
        productManager.add(book2);
        productManager.add(smartphone);
        Product[] products = new Product[]{book, book1};
        assertArrayEquals(products, productManager.searchBy("2"));
    }
    Smartphone smartphone = new Smartphone(4, "5", 210, "str");
    @Test
    public void testAddRepository() {

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
    public void testFindSmartphone() {
        ProductRepository repository = new ProductRepository();
        repository.add(book);
        repository.add(book1);
        repository.add(book2);
        repository.add(smartphone);
        assertEquals(smartphone, repository.findByld(4));

    }

    @Test
    public void testFindBook() {
        ProductRepository repository = new ProductRepository();
        repository.add(book);
        repository.add(book1);
        repository.add(book2);
        repository.add(smartphone);
        assertEquals(book2, repository.findByld(3));

    }

    @Test
    public void testDeleteElementRepository() {
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

    Book book4 = new Book();
    @Test

    public void testConstNoParametrBook() {
        ProductRepository repository = new ProductRepository();
        book4.setId(1);
        book4.setName("2");
        book4.setPrice(200);
        book4.setAuthor("TEXT");
        repository.add(book);
        repository.add(book1);
        repository.add(book2);
        repository.add(smartphone);
        repository.removeByld(2);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{book, book2, smartphone};
        assertArrayEquals(expected, actual);
    }
    Smartphone smartphone1 = new Smartphone();
    @Test
    public void testFindNameElementAndConstrNoParamSmartphone() {
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
    public void testGetPriceSmartphone() {
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
    public void testGetNameSmartphone() {
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
    public void repositoryFindByldNullTest() {
        ProductRepository repository = new ProductRepository();
        repository.add(book1);
        repository.add(book2);
        assertNull(repository.findByld(0));
    }







}
