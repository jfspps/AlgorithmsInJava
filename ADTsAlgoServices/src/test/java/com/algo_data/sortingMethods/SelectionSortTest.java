package com.algo_data.sortingMethods;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest {

    private int[] array;
    private SelectionSort selectionSort;

    @BeforeEach
    void setUp() {
        array = new int[]{2,4,3,5,4,6,5,7};
        selectionSort = new SelectionSort(array);
    }

    @Test
    void selectionSortArray() {
        // expecting 2, 3, 4, 4, 5, 5, 6, 7
        selectionSort.selectionSortArray();

        assertEquals("[2, 3, 4, 4, 5, 5, 6, 7]", Arrays.toString(selectionSort.getArray()));
    }
}