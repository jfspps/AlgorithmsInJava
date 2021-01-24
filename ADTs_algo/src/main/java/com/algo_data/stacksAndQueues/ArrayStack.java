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

        //remember this for ArrayList et. al. ADT implementations!
        this.stackArray = (T[]) new Object[this.stackSize];
        this.topIndex = -1;
    }

    public T push(T data) {
        // check if stack is already full (unlike linked lists)
        if (this.topIndex == this.stackSize - 1){
            System.out.println("Stack is full, cannot push to stack");
            return null;
        }
        this.stackArray[++this.topIndex] = data;
        return data;
    }

    public T pop(){
        if (topIndex == -1){
            System.out.println("Stack is empty");
            throw new EmptyStackException();
        }
        return stackArray[topIndex--];
    }

    public T peek(){
        if (topIndex == -1){
            System.out.println("Stack is already empty");
            return null;
        }
        return stackArray[topIndex];
    }

    public boolean isEmpty(){
        return topIndex < 0;
    }
}
