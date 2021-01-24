package com.algo_data.stacksAndQueues;

import java.util.EmptyStackException;

public class Stack<T> {

    // when instantiating a Stack, the respective nodes are private and accessible/viewed via pop(), push(), peek() and isEmpty()
    // note that the Stack and Queue are implemented here as linked lists to allow for dynamic allocation (arrays may also be used; see ArrayStack)
    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data){
            this.data = data;
        }
    }

    // references the top of the stack (last node in, first node out)
    private StackNode<T> top;

    // removes a new Node and updates top
    public T pop(){
        if (top == null){
            throw new EmptyStackException();
        }

        T item = top.data;
        top = top.next;
        return item;
    }

    // adds an item as the top node
    public void push(T item){
        StackNode<T> newItem = new StackNode<>(item);
        newItem.next = top;
        top = newItem;
    }

    // returns the current top item
    public T peek(){
        if (top == null){
            throw new EmptyStackException();
        }
        return top.data;
    }

    // checks if a stack is empty or not
    public boolean isEmpty(){
        return top == null;
    }
}
