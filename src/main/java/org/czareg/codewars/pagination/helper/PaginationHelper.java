package org.czareg.codewars.pagination.helper;

import java.util.List;

/*
For this exercise you will be strengthening your page-fu mastery.
You will complete the PaginationHelper class, which is a utility class helpful for querying paging information related to an array.

The class is designed to take in an array of values and an integer indicating how many items will be allowed per each page.
The types of values contained within the collection/array are not relevant.
 */
public class PaginationHelper<I> {

    private final List<I> collection;
    private final int itemsPerPage;

    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.collection = collection;
        this.itemsPerPage = itemsPerPage;
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return collection.size();
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        return ceilDiv(itemCount(), itemsPerPage);
    }

    private int ceilDiv(int x, int y) {
        return -Math.floorDiv(-x, y);
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        if (pageIndex >= pageCount() || pageIndex < 0) {
            return -1;
        }
        int startIndex = pageIndex * itemsPerPage;
        int endIndex = startIndex + itemsPerPage;
        if (endIndex >= itemCount()) {
            endIndex = itemCount();
        }
        return collection.subList(startIndex, endIndex).size();
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        if (collection.isEmpty() || itemIndex < 0 || itemIndex >= collection.size()) {
            return -1;
        }
        return itemIndex / itemsPerPage;
    }
}
