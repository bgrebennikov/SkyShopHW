package org.skypro.skyshop;

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

        System.out.println("--- Search results for 'B' (from long to short) ---");

        Set<Searchable> searchResults = searchEngine.search("B");

        if (searchResults.isEmpty()) {
            System.out.println("Not found");
        } else {
            for (Searchable item : searchResults) {
                System.out.println(item.getStringRepresentation());
                System.out.println("---");
            }
        }
    }

    private static SearchEngine buildSearchEngine() {
        SimpleProduct banana = new SimpleProduct("Banana", 150);
        FixedPriceProduct coconut = new FixedPriceProduct("Coconut");
        DiscountedProduct iphone = new DiscountedProduct("Iphone 15", 78000, 15);

        Article article = new Article("Banana and coconut smoothie recipe", "Here are a few ways to make a ...");
        Article article2 = new Article("Iphone 15 Review", "featuring a 48MP main camera, USB-C connectivity, and the Dynamic Island...");

        SearchEngine searchEngine = new SearchEngine();

        searchEngine.add(banana);
        searchEngine.add(banana);
        searchEngine.add(banana);

        searchEngine.add(coconut);
        searchEngine.add(iphone);
        searchEngine.add(article);
        searchEngine.add(article2);
        return searchEngine;
    }

}
