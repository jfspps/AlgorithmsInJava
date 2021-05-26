package com.algo_data.sortingMethods;

public class MergeSort {

    void startMergeSort(int[] array){
        int[] workingArray = new int[array.length];

        // split up the array into half until the lower index is the same as the upper index
        mergesort(array, workingArray, 0, array.length - 1);
    }

    void mergesort(int[] array, int[] workingArray, int lowerIndex, int upperIndex){
        if (lowerIndex < upperIndex){
            int halfwayPoint = lowerIndex + (upperIndex - lowerIndex)/2;

            // try to find the new indices again
            mergesort(array, workingArray, lowerIndex, halfwayPoint);
            mergesort(array, workingArray, halfwayPoint+1, upperIndex);

            // by now, the element indices would have been set such that (lowerIndex + 1 = upperIndex)
            mergeArrays(array, workingArray, lowerIndex, halfwayPoint, upperIndex);
        }
    }

    // called when lowerIndex < upperIndex
    void mergeArrays(int[] array, int[] workingArray, int lowerIndex, int halfwayPoint, int upperIndex){
        // on first call, the first two elements are copied across
        // on second call, the next two elements (if present) are then copied etc.
        for (int i = lowerIndex; i <= upperIndex; i++){
            workingArray[i] = array[i];
        }

        int workingLowerIndex = lowerIndex;
        int workingUpperIndex = halfwayPoint + 1;
        int currentLowest = lowerIndex;

        while (workingLowerIndex <= halfwayPoint && workingUpperIndex <= upperIndex){
            if (workingArray[workingLowerIndex] <= workingArray[workingUpperIndex]) {
                array[currentLowest] = workingArray[workingLowerIndex];
                workingLowerIndex++;
            } else {
                array[currentLowest] = workingArray[workingUpperIndex];
                workingUpperIndex++;
            }
            currentLowest++;
        }

        int elementsRemaining = halfwayPoint - workingLowerIndex;
        for (int i = 0; i <= elementsRemaining; i++){
            array[currentLowest + i] = workingArray[workingLowerIndex + i];
        }
    }
}
