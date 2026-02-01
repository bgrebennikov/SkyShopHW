package org.skypro.skyshop.blog;

import org.skypro.skyshop.common.ContentType;
import org.skypro.skyshop.search.Searchable;

public class Article implements Searchable {

    private final String title;
    private final String body;

    public Article(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "%s%n%s%n".formatted(title, body);
    }

    @Override
    public String getSearchTerm() {
        return this.toString();
    }

    @Override
    public String getContentType() {
        return ContentType.ARTICLE.name();
    }
}
