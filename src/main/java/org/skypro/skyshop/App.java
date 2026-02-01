package org.skypro.skyshop;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixedPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {

    public static void main(String[] args) {


        try {
            Product banana = new SimpleProduct("Banana", 0);
        } catch (IllegalArgumentException e) {
            System.out.printf("Error: %s\n", e.getMessage());
        }

        try {
            Product iphone = new DiscountedProduct("Iphone 15", 78000, -5);
        } catch (IllegalArgumentException e) {
            System.out.printf("Error: %s\n", e.getMessage());
        }
    }

}
