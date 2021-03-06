package com.algo_data.stacksAndQueues;

import java.util.EmptyStackException;

// array implementation of a stack
public class ArrayStack<T> {

    // Java would use boxed types (Integer, String, Character)
    // approach by storing items in an array, where the top item/node is updated after each method

    private final int stackSize;
    private final T[] stackArray;
    private int topIndex;

    public ArrayStack(int stackSize){
        //care needed to keep this execution away from client code until T is known
        this.stackSize = stackSize;
        this.stackArray = (T[]) new Object[this.stackSize];
        this.topIndex = -1;
    }

    /**
     * Pushes a new element or node (the data of which can be null) to the top of the stack.
     * New nodes' data can be null hence pop() and peek() return null if the data is null and throw exceptions when
     * the given stack is empty. ArrayStack is static-array based hence push() returns -1 of the array is full and 1 if
     * push was accomplished.
     * */
    public int push(T data) {
        // check if stack is already full (unlike linked lists)
        if (this.topIndex == this.stackSize - 1){
            System.out.println("Stack is full, cannot push to stack");
            return -1;
        }
        this.stackArray[++this.topIndex] = data;
        return 1;
    }

    /**
     * Removes and returns the uppermost node's or element's data from the stack; throws an EmptyStackException if stack is empty.
     * */
    public T pop(){
        if (topIndex == -1){
            System.out.println("Stack is empty");
            throw new EmptyStackException();
        }
        return stackArray[topIndex--];
    }

    /**
     * Returns a copy of the uppermost node (which can be null) or element of the given stack.
     * Throws an EmptyStackException if stack is empty.
     * */
    public T peek(){
        if (topIndex == -1){
            System.out.println("Stack is already empty");
            throw new EmptyStackException();
        }
        return stackArray[topIndex];
    }

    /**
     * Returns true if the stack is empty and false if not
     * */
    public boolean isEmpty(){
        return topIndex < 0;
    }
}
