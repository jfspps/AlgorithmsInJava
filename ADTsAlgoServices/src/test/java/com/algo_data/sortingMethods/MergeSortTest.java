package com.algo_data.sortingMethods;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    private int[] array;
    MergeSort mergeSort;

    @BeforeEach
    void setUp() {
        array = new int[]{2,5,3,4,9,7,1,5,7,4};
        mergeSort = new MergeSort();
    }

    @Test
    void startMergeSort() {
        mergeSort.startMergeSort(array);

        // expecting 1, 2, 3, 4, 4, 5, 5, 7, 7, 9
        assertEquals("[1, 2, 3, 4, 4, 5, 5, 7, 7, 9]", Arrays.toString(array));
    }
}