package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    private final int price;
    private final int discountPercent;

    public DiscountedProduct(String title, int price, int discountPercent) {
        super(title, price);
        this.price = price;
        this.discountPercent = discountPercent;
    }


    @Override
    public int getPrice() {
        return this.price * (this.discountPercent / 100);
    }
}
