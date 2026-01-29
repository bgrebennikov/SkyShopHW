package org.skypro.skyshop.product;

public abstract class Product {
    private final String title;

    public Product(String title, int price) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract int getPrice();

    @Override
    public String toString() {
        return "%s: %n".formatted(title);
    }
}
