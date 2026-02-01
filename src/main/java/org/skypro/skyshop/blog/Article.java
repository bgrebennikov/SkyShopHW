package org.skypro.skyshop.blog;

public class Article {

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
}
