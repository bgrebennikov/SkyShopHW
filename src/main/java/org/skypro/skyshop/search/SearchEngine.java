package org.skypro.skyshop.search;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {

    private final Searchable[] searchItems;
    private int size;

    public SearchEngine(int count) {
        this.searchItems = new Searchable[count];
        this.size = count;
    }

    public void add(Searchable searchItem) {
        if (size == searchItems.length) {
            System.arraycopy(searchItems, 0, searchItems, 1, searchItems.length - 1);
            searchItems[0] = searchItem;
        } else {
            System.arraycopy(searchItems, 0, searchItems, 1, size);
            searchItems[0] = searchItem;
            size++;
        }
    }


    public Searchable[] search(String query) {
        int limit = 5;

        List<Searchable> result = new ArrayList<>();

        for (int i = 0; i < searchItems.length; i++) {
            Searchable item = searchItems[i];
            if (item == null) {
                continue;
            }
            if (item.getSearchTerm().contains(query)) {
                result.add(item);
            }
            if (i > limit) {
                break;
            }
        }

        return result.toArray(new Searchable[0]);

    }


}
