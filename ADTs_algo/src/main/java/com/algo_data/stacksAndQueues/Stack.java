package com.algo_data.stacksAndQueues;

import java.util.EmptyStackException;

public class Stack<T> {

    // when instantiating a Stack, the respective nodes are private and accessible/viewed via pop(), push(), peek() and isEmpty()
    // note that the Stack and Queue are implemented here as linked lists to allow for dynamic allocation (arrays may also be employed; see ArrayStack)
    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data){
            this.data = data;
        }
    }

    // references the top of the stack (last node in, first node out)
    private StackNode<T> top;

    /**
     * Removes and returns the uppermost node's or element's data from the stack; throws an EmptyStackException if stack is empty.
     * */
    public T pop(){
        if (top == null){
            throw new EmptyStackException();
        }

        T item = top.data;
        top = top.next;
        return item;
    }

    /**
     * Pushes a new element or node (the data of which can be null) to the top of the stack.
     * New nodes' data can be null hence pop() and peek() return null if the data is null and throw exceptions when
     * the given stack is empty.
     * */
    public void push(T item){
        StackNode<T> newItem = new StackNode<>(item);
        newItem.next = top;
        top = newItem;
    }

    /**
     * Returns a copy of the uppermost node (which can be null) or element of the stack.
     * Throws an EmptyStackException if stack is empty.
     * */
    public T peek(){
        if (top == null){
            throw new EmptyStackException();
        }
        return top.data;
    }

    /**
     * Returns true if the stack is empty and false if not
     * */
    public boolean isEmpty(){
        return this.top == null;
    }
}
