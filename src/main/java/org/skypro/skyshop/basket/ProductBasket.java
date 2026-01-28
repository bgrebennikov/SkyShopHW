package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] store;

    public ProductBasket() {
        this.store = new Product[5];
    }

    public void addProduct(Product product) {
        if (product == null) return;

        for (int i = 0; i < this.store.length; i++) {
            if (this.store[i] == null) {
                this.store[i] = product;
                return;
            }
        }

        System.out.println("В корзине недостаточно места для добавления нового продукта");
    }

    public int getBasketAmountTotal() {

        int sum = 0;
        for (Product product : this.store) {
            if (product == null) continue;
            sum += product.getPrice();
        }

        return sum;
    }

    public void printBasketItems() {
        int itemsCount = 0;
        for (Product product : this.store) {
            if (product == null) continue;
            itemsCount++;
            System.out.print(product);
        }
        if (itemsCount < 1) {
            System.out.println("В корзине пусто.");
            return;
        }
        System.out.printf("Итого: %s%n", getBasketAmountTotal());
    }

    public boolean isProductExist(String title) {
        return false;
    }

    public void cleanBasket() {

    }

}
