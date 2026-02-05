package org.skypro.skyshop.exceptions;

public class BestResultNotFound extends Exception {
    public BestResultNotFound(String searchQuery) {
        super("Could not find best result for query: %s".formatted(searchQuery));
    }
}
