package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixedPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {

    public static void main(String[] args) {
        Product cheese = new SimpleProduct("Cheese", 200);
        Product milk = new DiscountedProduct("Milk", 122, 20);
        Product olives = new SimpleProduct("Olives", 165);
        Product coconut = new FixedPriceProduct("Coconut");

        ProductBasket basket = new ProductBasket();
        basket.addProduct(cheese);
        System.out.println("=== Добавили 1 продукт в корзину ===\n");
        basket.printBasketItems();

        System.out.println("=== Очищаем корзину и запрашиваем список товаров ===\n");
        basket.cleanBasket();
        basket.printBasketItems();

        System.out.println("=== Выводим стоимость пустой корзины ===\n");
        System.out.println(basket.getBasketAmountTotal());

        System.out.println("=== Пробуем добавить более 5 продуктов ===\n");

        basket.addProduct(milk);
        basket.addProduct(olives);
        basket.addProduct(coconut);
        basket.addProduct(milk);
        basket.addProduct(olives);
        basket.addProduct(coconut);

        basket.printBasketItems();

        System.out.println("=== Проверяем наличие товаров в корзине ===\n");
        System.out.printf("Olives: %s%n", basket.isProductExist("Olives"));
        System.out.printf("Sparkling water: %s%n", basket.isProductExist("Sparkling water"));

        System.out.println("=== Получаем товар из корзины по названию ===\n");
        System.out.printf("Olives: %s%n", basket.findProductByTitle("Olives"));
        System.out.printf("Chewing gum: %s%n", basket.findProductByTitle("Chewing gum"));


    }

}
