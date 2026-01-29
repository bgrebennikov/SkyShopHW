package org.skypro.skyshop.product;

public abstract class Product {
    private final String title;

    public Product(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract int getPrice();

    @Override
    public String toString() {
        return "%s: %s%n".formatted(title, getPrice());
    }
}
