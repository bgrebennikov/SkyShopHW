package org.skypro.skyshop.product;

public class FixedPriceProduct extends Product {

    private static final int FIXED_PRICE_PRODUCT = 350;

    public FixedPriceProduct(String title) {
        super(title);
    }


    @Override
    public int getPrice() {
        return FIXED_PRICE_PRODUCT;
    }
}
