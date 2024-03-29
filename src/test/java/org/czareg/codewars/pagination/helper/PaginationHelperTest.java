package org.czareg.codewars.pagination.helper;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PaginationHelperTest {

    @Test
    @Order(1)
    @DisplayName("Sample tests from description")
    void sampleTestsFromDescription() {
        List<Character> collection = List.of('a', 'b', 'c', 'd', 'e', 'f');
        PaginationHelper<Character> helper = new PaginationHelper<>(collection, 4);
        assertEquals(2, helper.pageCount(), "pageCount is returning incorrect value");
        assertEquals(6, helper.itemCount(), "itemCount is returning incorrect value");
        assertEquals(4, helper.pageItemCount(0), "pageItemCount is returning incorrect value for page 0");
        assertEquals(2, helper.pageItemCount(1), "pageItemCount is returning incorrect value for page 1");
        assertEquals(-1, helper.pageItemCount(2), "pageItemCount is returning incorrect value for page 2");
        assertEquals(1, helper.pageIndex(5), "pageIndex is returning incorrect value for index 5");
        assertEquals(0, helper.pageIndex(2), "pageIndex is returning incorrect value for index 2");
        assertEquals(-1, helper.pageIndex(20), "pageIndex is returning incorrect value for index 20");
        assertEquals(-1, helper.pageIndex(-10), "pageIndex is returning incorrect value for index -10");
    }

    @Test
    @Order(2)
    @DisplayName("Fixed tests")
    void fixedTest() {
        List<Integer> collection = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24);
        PaginationHelper<Integer> helper = new PaginationHelper<>(collection, 10);
        assertEquals(3, helper.pageCount(), "pageCount is returning incorrect value");
        assertEquals(24, helper.itemCount(), "itemCount is returning incorrect value");
        assertEquals(10, helper.pageItemCount(0), "pageItemCount is returning incorrect value for page 0");
        assertEquals(10, helper.pageItemCount(1), "pageItemCount is returning incorrect value for page 1");
        assertEquals(4, helper.pageItemCount(2), "pageItemCount is returning incorrect value for page 2");
        assertEquals(-1, helper.pageItemCount(3), "pageItemCount is returning incorrect value for page 3");
        assertEquals(-1, helper.pageItemCount(-1), "pageItemCount is returning incorrect value for page -1");
        assertEquals(0, helper.pageIndex(0), "pageIndex is returning incorrect value for index 0");
        assertEquals(0, helper.pageIndex(3), "pageIndex is returning incorrect value for index 3");
        assertEquals(0, helper.pageIndex(9), "pageIndex is returning incorrect value for index 9");
        assertEquals(1, helper.pageIndex(10), "pageIndex is returning incorrect value for index 10");
        assertEquals(1, helper.pageIndex(19), "pageIndex is returning incorrect value for index 19");
        assertEquals(2, helper.pageIndex(20), "pageIndex is returning incorrect value for index 20");
        assertEquals(2, helper.pageIndex(22), "pageIndex is returning incorrect value for index 22");
        assertEquals(2, helper.pageIndex(23), "pageIndex is returning incorrect value for index 23");
        assertEquals(-1, helper.pageIndex(24), "pageIndex is returning incorrect value when provided a itemIndex argument (24) that was out of range");
        assertEquals(-1, helper.pageIndex(40), "pageIndex is returning incorrect value when provided a itemIndex argument (40) that was out of range");
        assertEquals(-1, helper.pageIndex(-1), "pageIndex is returning incorrect value for negative index -1");
        assertEquals(-1, helper.pageIndex(-15), "pageIndex is returning incorrect value for negative index -15");
        assertEquals(-1, helper.pageIndex(-23), "pageIndex is returning incorrect value for negative index -23");
    }

    @Test
    @Order(3)
    @DisplayName("Edge case: List [1,2,3,4] with 4 items per page")
    void edgeCase1() {
        List<Integer> collection = List.of(1, 2, 3, 4);
        PaginationHelper<Integer> helper = new PaginationHelper<>(collection, 4);
        assertEquals(4, helper.itemCount(), "itemCount is returning incorrect value");
        assertEquals(1, helper.pageCount(), "pageCount is returning incorrect value");
        assertEquals(4, helper.pageItemCount(0), "pageItemCount is returning incorrect value for page 0");
        assertEquals(-1, helper.pageItemCount(1), "pageItemCount is returning incorrect value for page 1");
        assertEquals(0, helper.pageIndex(0), "pageIndex is returning incorrect value for index 0");
        assertEquals(0, helper.pageIndex(3), "pageIndex is returning incorrect value for index 3");
        assertEquals(-1, helper.pageIndex(4), "pageIndex is returning incorrect value for index 4");
    }

    @Test
    @Order(4)
    @DisplayName("Edge case: List [1,2,3,4] with 1 item per page")
    void edgeCase2() {
        List<Integer> collection = List.of(1, 2, 3, 4);
        PaginationHelper<Integer> helper = new PaginationHelper<>(collection, 1);
        assertEquals(4, helper.itemCount(), "itemCount is returning incorrect value");
        assertEquals(4, helper.pageCount(), "pageCount is returning incorrect value");
        assertEquals(1, helper.pageItemCount(0), "pageItemCount is returning incorrect value for page 0");
        assertEquals(1, helper.pageItemCount(1), "pageItemCount is returning incorrect value for page 1");
        assertEquals(1, helper.pageItemCount(2), "pageItemCount is returning incorrect value for page 2");
        assertEquals(1, helper.pageItemCount(3), "pageItemCount is returning incorrect value for page 3");
        assertEquals(-1, helper.pageItemCount(4), "pageItemCount is returning incorrect value for page 4");
        assertEquals(0, helper.pageIndex(0), "pageIndex is returning incorrect value for index 0");
        assertEquals(1, helper.pageIndex(1), "pageIndex is returning incorrect value for index 1");
        assertEquals(2, helper.pageIndex(2), "pageIndex is returning incorrect value for index 2");
        assertEquals(3, helper.pageIndex(3), "pageIndex is returning incorrect value for index 3");
        assertEquals(-1, helper.pageIndex(4), "pageIndex is returning incorrect value for index 4");
    }

    @Test
    @Order(5)
    @DisplayName("Empty collection")
    void emptyCollection() {
        PaginationHelper<?> empty = new PaginationHelper<>(List.of(), 10);
        assertEquals(0, empty.itemCount(), "itemCount is returning incorrect value");
        assertEquals(0, empty.pageCount(), "pageCount is returning incorrect value");
        assertEquals(-1, empty.pageIndex(0), "pageIndex(0) called when there was an empty collection");
        assertEquals(-1, empty.pageIndex(1), "pageIndex(1) called when there was an empty collection");
        assertEquals(-1, empty.pageIndex(-1), "pageIndex(-1) called when there was an empty collection");
        assertEquals(-1, empty.pageItemCount(0), "pageItemCount is returning incorrect value for page 0");
        assertEquals(-1, empty.pageItemCount(1), "pageItemCount is returning incorrect value for page 1");
    }

    private static final Random rnd = ThreadLocalRandom.current();

    @Test
    @Order(6)
    @DisplayName("Random tests")
    void randomTests() {
        for (int run = 0; run < 40; ++run) {
            List<Object> list = Stream.generate(this::randomElement).limit(rnd.nextLong(50L)).toList();
            int itemsPerPage = rnd.nextInt(1, list.size() + list.size() / 2 + 2);
            PaginationHelper<Object> helper = new PaginationHelper<>(list, itemsPerPage);

            int expectedPageCount = (int) Math.ceil((double) list.size() / itemsPerPage);
            assertEquals(expectedPageCount, helper.pageCount(), "pageCount is returning incorrect value");
            assertEquals(list.size(), helper.itemCount(), "itemCount is returning incorrect value");

            List<Integer> pages = IntStream.range(-5, expectedPageCount + 5).boxed().collect(Collectors.toList());
            Collections.shuffle(pages);
            for (int p : pages) {
                int expectedPageItemCount = p < 0 || p >= expectedPageCount ? -1 : p < expectedPageCount - 1 ? itemsPerPage : list.size() % itemsPerPage;
                expectedPageItemCount = expectedPageItemCount == 0 ? itemsPerPage : expectedPageItemCount;
                assertEquals(expectedPageItemCount, helper.pageItemCount(p), "pageItemCount is returning incorrect value for page " + p);
            }

            List<Integer> itemIndices = IntStream.range(-5, list.size() + 10).boxed().collect(Collectors.toList());
            Collections.shuffle(itemIndices);
            for (int i : itemIndices) {
                int expectedPageIndex = i < 0 || i >= list.size() ? -1 : i / itemsPerPage;
                assertEquals(expectedPageIndex, helper.pageIndex(i), "pageIndex is returning incorrect value for index " + i);
            }
        }
    }

    private Object randomElement() {
        return switch (rnd.nextInt(4)) {
            case 0 -> rnd.nextInt(100);
            case 1 -> (char) rnd.nextInt(32, 128);
            case 2 ->
                    rnd.ints(rnd.nextLong(5L), 32, 128).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
            default -> new Object();
        };
    }

    @Test
    @Order(7)
    @DisplayName("Edge case: methods should return correct values after new elements are added to the list")
    void edgeCase3() {
        List<String> list = new ArrayList<>();
        PaginationHelper<?> empty = new PaginationHelper<>(list, 3);
        assertEquals(0, empty.itemCount());
        assertEquals(0, empty.pageCount());
        assertEquals(-1, empty.pageIndex(0));
        assertEquals(-1, empty.pageItemCount(0));

        list.add("1");
        assertEquals(1, empty.itemCount());
        assertEquals(1, empty.pageCount());
        assertEquals(0, empty.pageIndex(0));
        assertEquals(1, empty.pageItemCount(0));

        list.add("2");
        list.add("3");
        list.add("4");
        assertEquals(4, empty.itemCount());
        assertEquals(2, empty.pageCount());
        assertEquals(0, empty.pageIndex(0));
        assertEquals(0, empty.pageIndex(1));
        assertEquals(1, empty.pageIndex(3));
        assertEquals(3, empty.pageItemCount(0));
        assertEquals(1, empty.pageItemCount(1));

        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");

        assertEquals(10, empty.itemCount());
        assertEquals(4, empty.pageCount());
        assertEquals(0, empty.pageIndex(0));
        assertEquals(0, empty.pageIndex(1));
        assertEquals(1, empty.pageIndex(3));
        assertEquals(2, empty.pageIndex(7));
        assertEquals(3, empty.pageIndex(9));
        assertEquals(3, empty.pageItemCount(0));
        assertEquals(3, empty.pageItemCount(1));
        assertEquals(1, empty.pageItemCount(3));
    }
}