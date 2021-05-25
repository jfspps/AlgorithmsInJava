package com.algo_data.sortingMethods;

public class SelectionSort {

    private int[] array;

    public SelectionSort(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    /**
     * Performs a selection sort on an array of integers
     * Time complexity is O(n(n-1)/2) or approx O(n^2)
     */
    public void selectionSortArray() {
        int length = this.array.length;
        int i, j, k;

        for(i = 0; i < length - 1; i++)
        {
            for(j = k = i; j < length; j++)
            {
                if(this.array[j] < this.array[k])
                    k = j;
            }
            int temp = this.array[i];
            this.array[i] = this.array[k];
            this.array[k] = temp;
        }
    }
}
