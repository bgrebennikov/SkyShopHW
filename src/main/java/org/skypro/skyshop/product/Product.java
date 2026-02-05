package org.skypro.skyshop.product;

import org.skypro.skyshop.common.ContentType;
import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    private final String title;

    public Product(String title) {

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title cannot be null or blank");
        }

        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract double getPrice();

    public abstract boolean isSpecial();

    @Override
    public String toString() {
        return "%s: %s%n".formatted(title, getPrice());
    }

    @Override
    public String getSearchTerm() {
        return title;
    }

    @Override
    public String getContentType() {
        return ContentType.PRODUCT.name();
    }
}
