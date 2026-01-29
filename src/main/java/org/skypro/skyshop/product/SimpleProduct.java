package org.skypro.skyshop.product;

public class SimpleProduct extends Product {

    private final int price;

    public SimpleProduct(String title, int price) {
        super(title);
        this.price = price;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
