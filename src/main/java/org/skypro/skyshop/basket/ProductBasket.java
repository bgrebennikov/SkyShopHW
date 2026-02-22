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
        return store.values().stream()
                .flatMap(Collection::stream)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public void printBasketItems() {
        List<Product> allProducts = store.values().stream()
                .flatMap(Collection::stream)
                .toList();

        if (allProducts.isEmpty()) {
            System.out.println("В корзине пусто.");
            return;
        }

        allProducts.forEach(System.out::print);

        long specialItemsCount = allProducts.stream()
                .filter(Product::isSpecial)
                .count();

        System.out.printf("Итого: %s%n", getBasketAmountTotal());
        System.out.printf("Специальных товаров: %d%n", specialItemsCount);
    }

    public boolean isProductExist(String title) {
        if (title == null) return false;

        return store.values().stream()
                .flatMap(Collection::stream)
                .anyMatch(product -> product.getTitle().equals(title));

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
