package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.blog.Article;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixedPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Set;

public class App {

    public static void main(String[] args) {
        SearchEngine searchEngine = buildSearchEngine();

        System.out.println("=== ДЕМОНСТРАЦИЯ ПОИСКА ===");
        System.out.println("Поиск 'Banana' (должен быть 1 товар и 1 статья по убыванию длины):");
        printSearchResults(searchEngine, "Banana");

        System.out.println("Поиск отсутствующего товара 'Apple':");
        printSearchResults(searchEngine, "Apple");

        System.out.println("\n=== ДЕМОНСТРАЦИЯ КОРЗИНЫ ===");
        ProductBasket basket = new ProductBasket();

        basket.addProduct(new SimpleProduct("Banana", 150));
        basket.addProduct(new DiscountedProduct("Iphone 15", 80000, 10));
        basket.addProduct(new FixedPriceProduct("Coconut"));
        basket.addProduct(new DiscountedProduct("Sale Banana", 100, 50));

        System.out.println("Содержимое корзины (через flatMap и forEach):");
        basket.printBasketItems();

        System.out.println("\nПроверка наличия 'Iphone 15' (anyMatch): " + basket.isProductExist("Iphone 15"));
        System.out.println("Проверка наличия 'Milk' (anyMatch): " + basket.isProductExist("Milk"));

        basket.cleanBasket();
        System.out.println("\nПосле очистки:");
        basket.printBasketItems();
    }

    private static void printSearchResults(SearchEngine engine, String query) {
        Set<Searchable> results = engine.search(query);
        if (results.isEmpty()) {
            System.out.println("Ничего не найдено.");
        } else {
            results.forEach(item -> System.out.println(item.getStringRepresentation()));
        }
        System.out.println("---");
    }

    private static SearchEngine buildSearchEngine() {
        SearchEngine engine = new SearchEngine();
        SimpleProduct banana = new SimpleProduct("Banana", 150);

        engine.add(banana);
        engine.add(banana);
        engine.add(banana);

        engine.add(new Article("Banana and coconut smoothie recipe", "Recipe text..."));
        engine.add(new FixedPriceProduct("Coconut"));

        return engine;
    }
}