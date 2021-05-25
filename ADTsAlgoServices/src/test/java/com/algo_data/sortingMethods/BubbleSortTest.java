package com.algo_data.sortingMethods;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    private int[] unsorted;
    private BubbleSort bubbleSort;

    @BeforeEach
    void setUp() {
        unsorted = new int[]{2,5,3,6,4,7,8};
        bubbleSort = new BubbleSort(unsorted);
    }

    @Test
    void bubbleSortArray() {
        // expect 2, 3, 4, 5, 6, 7, 8
        bubbleSort.bubbleSortArray();

        assertEquals("[2, 3, 4, 5, 6, 7, 8]", Arrays.toString(bubbleSort.getArray()));
    }
}