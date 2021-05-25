package com.algo_data.sortingMethods;

public class BubbleSort {

    private int[] array;

    public BubbleSort(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    /**
     * Performs a bubble sort on a primitive array of integers
     * The worst case is O(n^2) (approx of O(n(n-1)/2))
     */
    public void bubbleSortArray() {
        // require a maximum of n passes to sort an array of n elements
        int length = this.array.length;

        for(int pass = 0; pass < length-1; pass++)
        {
            boolean swapped = false;
            for(int j = 0; j < length-pass-1; j++)
            {
                if(this.array[j] > this.array[j+1])
                {
                    int temp = this.array[j];
                    this.array[j] = this.array[j+1];
                    this.array[j+1] = temp;
                    swapped = true;
                }
            }
            // stop bubbleSort performing more unnecessary passes
            if(!swapped)
                break;
        }
    }
}
