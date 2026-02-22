package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.*;

public class SearchEngine {

    private final Set<Searchable> searchItems;

    public SearchEngine() {
        this.searchItems = new HashSet<>();
    }

    public void add(Searchable searchItem) {
        if (searchItem == null) {
            return;
        }
        searchItems.add(searchItem);
    }

    private int countOccurrences(String text, String search) {
        int count = 0;
        int index = 0;

        int foundIndex = text.indexOf(search, index);
        while (foundIndex != -1) {
            count++;
            index = foundIndex + search.length();
            foundIndex = text.indexOf(search, index);
        }

        return count;
    }

    public Searchable findBestResult(String search) throws BestResultNotFound {
        if (search == null || search.isEmpty()) {
            throw new IllegalArgumentException("search cannot be null or empty");
        }

        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable item : searchItems) {
            if (item == null) continue;

            String term = item.getSearchTerm();
            if (term == null) continue;

            int count = countOccurrences(term, search);
            if (count > maxCount) {
                maxCount = count;
                bestMatch = item;
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound(search);
        }
        return bestMatch;
    }

    public Set<Searchable> search(String query) {
        Set<Searchable> result = new TreeSet<>(new SearchableComparator());

        if (query == null || query.isEmpty()) {
            return result;
        }

        for (Searchable item : searchItems) {
            if (item != null && item.getSearchTerm().contains(query)) {
                result.add(item);
            }
        }
        return result;
    }
}
