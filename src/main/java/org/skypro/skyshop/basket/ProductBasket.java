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

    public double getBasketAmountTotal() {

        double sum = 0;
        for (Product product : this.store) {
            if (product == null) continue;
            sum += product.getPrice();
        }

        return sum;
    }

    public void printBasketItems() {
        int itemsCount = 0;
        int specialItemsCount = 0;

        for (Product product : this.store) {
            if (product == null) continue;
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
        for (Product product : this.store) {
            if (product == null) continue;
            if (product.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    public Product findProductByTitle(String title) {
        if (title == null) return null;
        for (Product product : this.store) {
            if (product == null) continue;
            if (product.getTitle().equals(title)) {
                return product;
            }
        }
        return null;
    }

    public void cleanBasket() {
        for (int i = 0; i < this.store.length; i++) {
            store[i] = null;
        }
    }

}
