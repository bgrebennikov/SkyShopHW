package org.skypro.skyshop;

import org.skypro.skyshop.blog.Article;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixedPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        Product banana = new SimpleProduct("Banana", 150);
        Product coconut = new FixedPriceProduct("Coconut");
        Product iphone = new DiscountedProduct("Iphone 15", 78000, 15);

        Article article = new Article(
                "banana and coconut smoothie recipe",
                "Here are a few ways to make a ..."
        );
        Article article2 = new Article(
                "Iphone 15 Review",
                "featuring a 48MP main camera, USB-C connectivity, and the Dynamic Island..."
        );

        SearchEngine searchEngine = new SearchEngine(5);

        searchEngine.add(banana);
        searchEngine.add(coconut);
        searchEngine.add(iphone);
        searchEngine.add(article);
        searchEngine.add(article2);

        printSearchResult("Iphone 15", searchEngine.search("Iphone 15"));

        printSearchResult(
                "banana and coconut smoothie recipe",
                searchEngine.search("banana and coconut smoothie recipe")
        );

        printSearchResult("qwerty", searchEngine.search("qwerty"));
    }

    private static void printSearchResult(String query, Searchable[] results) {
        System.out.println("Search query: \"" + query + "\"");

        if (results.length == 0) {
            System.out.println("Nothing found");
        } else {
            Arrays.stream(results)
                    .map(Searchable::getStringRepresentation)
                    .forEach(System.out::println);
        }

        System.out.println();
    }
}
