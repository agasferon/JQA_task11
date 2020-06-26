package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    private Book testBook = new Book(1001, "По ком звонит колокол", 500, "Э. Хемингуэй");

    @Test
    void matchesBookByAuthor(){
        assertTrue(testBook.matches("Э. Хемингуэй"));
    }

    @Test
    void matchesBookByName(){
        assertTrue(testBook.matches("По ком звонит колокол"));
    }

    @Test
    void notMatchesBook(){
        assertFalse(testBook.matches("Молох"));
    }

}