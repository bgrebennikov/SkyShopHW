package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {

    private final Searchable[] searchItems;

    public SearchEngine(int count) {
        this.searchItems = new Searchable[count];
    }

    public void add(Searchable searchItem) {
        if (searchItem == null) {
            return;
        }

        for (int i = 0; i < searchItems.length; i++) {
            if (searchItems[i] == null) {
                searchItems[i] = searchItem;
                return;
            }
        }

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
            String term = item.getSearchTerm();
            if (term == null) {
                continue;
            }

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


    public Searchable[] search(String query) {
        int limit = 5;

        if (query == null || query.isEmpty()) {
            return new Searchable[0];
        }

        List<Searchable> result = new ArrayList<>();

        for (Searchable item : searchItems) {
            if (item == null) {
                continue;
            }

            if (item.getSearchTerm().contains(query)) {
                result.add(item);

                if (result.size() == limit) {
                    break;
                }
            }
        }

        return result.toArray(new Searchable[0]);
    }


}
