package com.algo_data.sortingMethods;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    private int[] array;
    private QuickSort quickSort;

    @BeforeEach
    void setUp() {
        array = new int[]{1,3,2,4,5,7,6,9,10};
        quickSort = new QuickSort();
    }

    @Test
    void quickSort() {
        System.out.println(Arrays.toString(array));
        quickSort.quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));

        // expect [1, 2, 3, 4, 5, 6, 7, 9, 10]
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 9, 10]", Arrays.toString(array));
    }
}