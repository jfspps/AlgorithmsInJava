package com.algo_data.arrays;

public class CustomArrayList<T> {

    private final T[] arrayList;
    private final int capacity;
    private int length;

    public CustomArrayList(int capacity) {
        this.capacity = capacity;
        this.arrayList = (T[]) new Object[this.capacity];
        this.length = 0;
    }

    /**
     * Adds a new element to array at the lowest-index null element.
     *
     * The array capacity increases automatically when the array is already half-full.
     *
     * Returns a reference to the array added to.
     */
    public CustomArrayList<T> add(T newElement){
        if (capacity/length < 2){
            CustomArrayList<T> newArray = new CustomArrayList<>(2*capacity);
            int i;
            for (i = 0; i < this.length; i++) {
                newArray.arrayList[i] = this.arrayList[i];
                newArray.length++;
            }
            newArray.arrayList[i+1] = newElement;
            newArray.length++;
            return newArray;
        } else {
            // get to the next null element
            int j = 0;
            while (this.arrayList[j] != null){
                j++;
            }
            this.arrayList[j] = newElement;

            if (j == length){
                this.length++;
            }
            return this;
        }
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
     * Returns the index of the element if found and returns -1 if not found.
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
    public T remove(T element){
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
     *
     * Returns the array reference if valid (array may have been expanded) and null otherwise.
     * */
    public CustomArrayList<T> set(T newElement, int index){
        if (index < 0){
            return null;
        }

        if (index < length){
            this.arrayList[index] = newElement;
            return this;
        } else {
            // build a new array just large enough
            CustomArrayList<T> newArray = new CustomArrayList<>(index);
            for (int i = 0; i < this.length; i++) {
                newArray.arrayList[i] = this.arrayList[i];
            }
            newArray.arrayList[index] = newElement;
            newArray.length = index + 1;
            return newArray;
        }
    }
}
