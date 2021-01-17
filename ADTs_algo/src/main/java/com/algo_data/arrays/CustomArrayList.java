package com.algo_data.arrays;

public class CustomArrayList<T> {

    private T[] arrayList;
    private int capacity;
    private int length;

    public CustomArrayList(int capacity) {
        if (capacity == 0){
            this.capacity = 1;
        } else
            this.capacity = capacity;

        this.arrayList = (T[]) new Object[this.capacity];
        this.length = 0;
    }

    /**
     * Adds a new element to array at the lowest-index null element (not necessarily the end of the array).
     * The array capacity increases automatically when the number of free elements remaining is one.
     */
    public void add(T newElement){
        if (length > 0 && capacity - length < 2){
            CustomArrayList<T> newArray = new CustomArrayList<>(2 * this.capacity);
            int thisLength = clone(newArray);

            newArray.arrayList[thisLength] = newElement;

            // re-reference this.arrayList and properties
            this.arrayList = newArray.arrayList;
            this.capacity = newArray.capacity;
            this.length++;
        } else {
            // get to the next null element
            int j = 0;
            while (this.arrayList[j] != null){
                j++;
            }
            this.arrayList[j] = newElement;

            // only increment this.length if newElement was added at the end
            if (j == length){
                this.length++;
            }
        }
    }

    /**
     * Helper function that copies this.arrayList to a new array.
     * Returns this.length.
     */
    private int clone(CustomArrayList<T> newArray) {
        int i;
        for (i = 0; i < this.length; i++) {
            newArray.arrayList[i] = this.arrayList[i];
        }
        return i;
    }

    /**
     * Returns the index of the first null element that proceeds the highest non-null element.
     * */
    public int size(){
        return this.length;
    }

    /**
     * Returns true if the array is empty and false if not.
     * */
    public boolean isEmpty(){
        return this.length == 0;
    }

    /**
     * Retrieves the element (which can be null) at the supplied index and returns null if not found.
     * */
    public T get(int index){
        if (index < length){
            return this.arrayList[index];
        } else
            return null;
    }

    /**
     * Clears the entire array and pads all elements as null, while resetting the length to zero.
     *
     * The capacity of and reference to the array are not changed.
     * */
    public void clear(){
        // use the same memory allocation
        for (int i = 0; i < this.length; i++){
            this.arrayList[i] = null;
        }
        this.length = 0;
    }

    /**
     * Returns the lowest index of the element if found and returns -1 if not found.
     * */
    public int indexOf(T element){
        for (int i = 0; i < this.length; i++){
            if (this.arrayList[i] == element){
                return i;
            }
        }
        return -1;
    }

    /**
     * Sets the first element found as null, returning the element (which can be null) if valid and null if not.
     * */
    public T removeElement(T element){
        int index = this.indexOf(element);
        T temp = null;

        if (index >= 0){
            temp = this.arrayList[index];
            this.arrayList[index] = null;
            if (index == length - 1){
                this.length--;
            }
        }
        return temp;
    }

    /**
     * Sets the element at the provided index to null and returns the previous value of the element (which can be null).
     * */
    public T removeAtIndex(int index){
        T temp = null;
        if (index >= 0){
            temp = this.get(index);
            this.arrayList[index] = null;
        }
        return temp;
    }

    /**
     * Assigns the element at the supplied index with the newElement value provided.
     *
     * This method is also equivalent to addAtIndex(), and expands the array as necessary to accommodate the newElement.
     * */
    public void set(T newElement, int index){
        if (index < 0){
            return;
        }

        if (index < length){
            this.arrayList[index] = newElement;
        } else {
            // build a new array just large enough
            CustomArrayList<T> newArray = new CustomArrayList<>(index+1);
            this.clone(newArray);

            newArray.arrayList[index] = newElement;
            this.arrayList = newArray.arrayList;
            this.length = index + 1;
            this.capacity = newArray.capacity;
        }
    }
}
