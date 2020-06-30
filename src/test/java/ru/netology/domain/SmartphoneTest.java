package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    private Smartphone testSmartphone = new Smartphone(2, "Nexus 5", 300, "Google");

    @Test
    void matchesSmartphoneByVendor(){
        assertTrue(testSmartphone.matches("Google"));
    }

    @Test
    void matchesSmartphoneByName(){
        assertTrue(testSmartphone.matches("Nexus 5"));
    }

    @Test
    void notMatchesSmartphone(){
        assertFalse(testSmartphone.matches("gnusmaS"));
    }
}