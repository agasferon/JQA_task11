package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    ProductRepository repository = new ProductRepository();

    private Book book = new Book(1, "По ком звонит колокол", 500, "Э. Хемингуэй");
    private Smartphone smartphone = new Smartphone(2, "Nexus 5", 300, "Google");

    @Test
    void removeByIdIfExist(){
        repository.save(book);
        repository.save(smartphone);
        repository.removeById(1);
        Product[] expected = new Product[]{smartphone};
        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    void getNotFoundExceptionIfNotExist(){
        repository.save(book);
        repository.save(smartphone);
        assertThrows(NotFoundException.class, () -> repository.removeById(6));
    }

}