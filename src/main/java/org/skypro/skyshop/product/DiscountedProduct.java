package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    private final int price;
    private final int discountPercent;

    public DiscountedProduct(String title, int price, int discountPercent) {
        super(title);
        this.price = price;
        this.discountPercent = discountPercent;
    }


    @Override
    public double getPrice() {
        return price - (price * ((double) discountPercent / 100));
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return "%s со скидкой: %s%n".formatted(this.getTitle(), this.getPrice());
    }
}
