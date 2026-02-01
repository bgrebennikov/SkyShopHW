package org.skypro.skyshop.search;

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
