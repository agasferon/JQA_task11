package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    private Book book = new Book(1, "По ком звонит колокол", 500, "Э. Хемингуэй");
    private Smartphone smartphone = new Smartphone(2, "Nexus 5", 300, "Google");

    @Test
    void shouldSearchBookByName() {
        ProductManager manager = new ProductManager();
        manager.add(book);
        Product[] expected = new Book[]{book};
        Product[] actual = manager.searchBy("По ком звонит колокол");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookByAuthor() {
        ProductManager manager = new ProductManager();
        manager.add(book);
        Product[] expected = new Book[]{book};
        Product[] actual = manager.searchBy("Э. Хемингуэй");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchPhoneByVendor() {
        ProductManager manager = new ProductManager();
        manager.add(smartphone);
        Product[] expected = new Smartphone[]{smartphone};
        Product[] actual = manager.searchBy("Nexus 5");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchPhoneByName() {
        ProductManager manager = new ProductManager();
        manager.add(smartphone);
        Product[] expected = new Smartphone[]{smartphone};
        Product[] actual = manager.searchBy("Google");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldntSearchBookIfNotExist() {
        ProductManager manager = new ProductManager();
        manager.add(book);
        Product[] expected = new Book[0];
        Product[] actual = manager.searchBy("Ф. Ницше");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldntSearchPhoneIfNotExist() {
        ProductManager manager = new ProductManager();
        manager.add(smartphone);
        Product[] expected = new Smartphone[0];
        Product[] actual = manager.searchBy("Таксофон");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        int idToRemove = 1;
        ProductManager manager = new ProductManager();
        manager.add(book);
        manager.add(smartphone);
        manager.removeById(idToRemove);
        Product[] actual = manager.getAll();
        Product[] expected = new Product[]{smartphone};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldntRemoveByIdIfNotExist() {
        int idToRemove = 6;
        ProductManager manager = new ProductManager();
        manager.add(book);
        manager.add(smartphone);
        manager.removeById(idToRemove);
        Product[] actual = manager.getAll();
        Product[] expected = new Product[]{smartphone, book};
        assertArrayEquals(expected, actual);
    }

}