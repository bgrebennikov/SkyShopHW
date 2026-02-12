package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> store;

    public ProductBasket() {
        this.store = new TreeMap<>();
    }

    public void addProduct(Product product) {
        if (product == null) return;

        store
                .computeIfAbsent(
                        product.getTitle(), key -> new ArrayList<>()
                )
                .add(product);

    }

    public double getBasketAmountTotal() {

        double sum = 0;

        for (List<Product> productValue : store.values()) {
            for (Product product : productValue) {
                sum += product.getPrice();
            }
        }

        return sum;
    }

    public void printBasketItems() {
        int itemsCount = 0;
        int specialItemsCount = 0;

        for (List<Product> product : store.values()) {
            for (Product productItem : product) {
                itemsCount++;
                if (productItem.isSpecial()) {
                    specialItemsCount++;
                }
                System.out.print(product);
            }
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

        for (List<Product> product : store.values()) {
            for (Product productItem : product) {
                if (productItem == null) continue;
                if (productItem.getTitle().equals(title)) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<Product> findProductByTitle(String title) {
        if (title == null) return null;

        return store.getOrDefault(title, Collections.emptyList());
    }

    public List<Product> removeByName(String productName) {
        if (productName.isBlank() || !store.containsKey(productName)) return new ArrayList<>();
        return store.remove(productName);

    }

    public void cleanBasket() {
        store.clear();
    }

}
