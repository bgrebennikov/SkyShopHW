package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {
    private final LinkedList<Product> store;

    public ProductBasket() {
        this.store = new LinkedList<>();
    }

    public void addProduct(Product product) {
        if (product == null) return;
        store.add(product);
    }

    public double getBasketAmountTotal() {

        double sum = 0;
        for (Product product : store) {
            sum += product.getPrice();
        }

        return sum;
    }

    public void printBasketItems() {
        int itemsCount = 0;
        int specialItemsCount = 0;

        for (Product product : this.store) {
            itemsCount++;
            if (product.isSpecial()) {
                specialItemsCount++;
            }
            System.out.print(product);
        }
        if (itemsCount < 1) {
            System.out.println("В корзине пусто.");
            return;
        }
        System.out.printf("Итого: %s%n", getBasketAmountTotal());
        System.out.printf("Специальных товаров: %d%n", specialItemsCount);
    }

    public boolean isProductExist(String title) {
        if (title == null) return false;

        for (Product product : store) {
            if (product == null) continue;
            if (product.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    public Product findProductByTitle(String title) {
        if (title == null) return null;

        for (Product product : store) {
            if (product.getTitle().equals(title)) {
                return product;
            }
        }
        return null;
    }

    public List<Product> removeByName(String productName) {
        List<Product> removedItems = new LinkedList<>();
        if (productName == null) return removedItems;

        Iterator<Product> iterator = store.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (productName.equals(product.getTitle())) {
                removedItems.add(product);
                iterator.remove();
            }
        }

        return removedItems;

    }

    public void cleanBasket() {
        store.clear();
    }

}
