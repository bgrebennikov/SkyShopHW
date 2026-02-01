package org.skypro.skyshop;

import org.skypro.skyshop.blog.Article;
import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixedPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

public class App {

    public static void main(String[] args) {

        SearchEngine searchEngine = buildSearchEngine();

        try {
            Searchable result = searchEngine.findBestResult("Banana");
            System.out.printf("Best result found for \"Banana\": %s%n", result);
        } catch (BestResultNotFound e) {
            System.out.printf("Error for \"Banana\": %s%n", e.getMessage());
        }

        try {
            Searchable result2 = searchEngine.findBestResult("Dynamic Island");
            System.out.printf("Best result found for \"Dynamic Island\": %s%n", result2);
        } catch (BestResultNotFound e) {
            System.out.printf("Error for \"Dynamic Island\": %s%n", e.getMessage());
        }

        try {
            Searchable result3 = searchEngine.findBestResult("azaza");
            System.out.printf("Best result found for \"azaza\": %s%n", result3);
        } catch (BestResultNotFound e) {
            System.out.printf("Error for \"azaza\": %s%n", e.getMessage());
        }

        try {
            Searchable result4 = searchEngine.findBestResult("");
            System.out.printf("Best result found for empty string: %s%n", result4);
        } catch (IllegalArgumentException e) {
            System.out.printf("Input Error for empty string: %s%n", e.getMessage());
        } catch (BestResultNotFound e) {
            System.out.printf("Error for empty string: %s%n", e.getMessage());
        }
    }

    private static SearchEngine buildSearchEngine() {
        SimpleProduct banana = new SimpleProduct("Banana", 150);
        FixedPriceProduct coconut = new FixedPriceProduct("Coconut");
        DiscountedProduct iphone = new DiscountedProduct("Iphone 15", 78000, 15);

        Article article = new Article("banana and coconut smoothie recipe", "Here are a few ways to make a ...");
        Article article2 = new Article("Iphone 15 Review", "featuring a 48MP main camera, USB-C connectivity, and the Dynamic Island...");

        SearchEngine searchEngine = new SearchEngine(5);

        searchEngine.add(banana);
        searchEngine.add(coconut);
        searchEngine.add(iphone);
        searchEngine.add(article);
        searchEngine.add(article2);
        return searchEngine;
    }
}
