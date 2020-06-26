package ru.netology.domain;

public class Product {
  private int id;
  private String name;
  private int price;

  public Product() {
  }

  public Product(int id, String name, int price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public boolean matches(String search) {
    if (this.getName().matches(search)) {
      return true;
    }
    return false;
  }

}