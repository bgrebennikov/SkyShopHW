package org.skypro.skyshop.search;

import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable o1, Searchable o2) {
        String term1 = o1.getSearchTerm();
        String term2 = o2.getSearchTerm();

        int lenCompare = Integer.compare(term2.length(), term1.length());

        if (lenCompare != 0) {
            return lenCompare;
        }

        return term1.compareTo(term2);
    }
}
