package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    private Book book = new Book(1001, "По ком звонит колокол", 500, "Э. Хемингуэй");
    private Smartphone smartphone = new Smartphone(2001, "Nexus 5", 300, "Google");

    @Test
    void shouldSearchBookByName() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        repository.save(book);
        Product[] expected = new Book[]{book};
        Product[] actual = manager.searchBy("По ком звонит колокол");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookByAuthor() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        repository.save(book);
        Product[] expected = new Book[]{book};
        Product[] actual = manager.searchBy("Э. Хемингуэй");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchPhoneByVendor() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        repository.save(smartphone);
        Product[] expected = new Smartphone[]{smartphone};
        Product[] actual = manager.searchBy("Nexus 5");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchPhoneByName() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        repository.save(smartphone);
        Product[] expected = new Smartphone[]{smartphone};
        Product[] actual = manager.searchBy("Google");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldntSearchBookIfNotExist() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        repository.save(book);
        Product[] expected = new Book[0];
        Product[] actual = manager.searchBy("Ф. Ницше");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldntSearchPhoneIfNotExist() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        repository.save(smartphone);
        Product[] expected = new Smartphone[0];
        Product[] actual = manager.searchBy("Таксофон");
        assertArrayEquals(expected, actual);
    }

}