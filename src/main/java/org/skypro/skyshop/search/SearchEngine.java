package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SearchEngine {

    private final LinkedList<Searchable> searchItems;

    public SearchEngine() {
        this.searchItems = new LinkedList<>();
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
            if (item == null) continue; // на всякий
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


    public List<Searchable> search(String query) {
        if (query == null || query.isEmpty()) {
            return List.of();
        }

        List<Searchable> result = new LinkedList<>();
        for (Searchable item : searchItems) {
            if (item == null) continue;

            String term = item.getSearchTerm();
            if (term != null && term.contains(query)) {
                result.add(item);
            }
        }
        return result;
    }


}
