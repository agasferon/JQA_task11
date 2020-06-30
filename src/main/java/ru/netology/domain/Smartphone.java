package ru.netology.domain;

public class Smartphone extends Product{
    private String vendor;

    public Smartphone(int id, String name, int price, String vendor) {
        super(id, name, price);
        this.vendor = vendor;
    }

    @Override
    public boolean matches(String search) {
        return super.matches(search) || vendor.equalsIgnoreCase(search);
    }

}