package com.algo_data.stacksAndQueues;

// a queue data structure implemented with two stacks
// stackIn is filled before item from enqueue(item) is added
// stackOut is filled before item from dequeue() is removed

public class QueueAsStacks<T> {

    // use the linked list implementation of a stack (stackSize not required on startup)
    private final Stack<T> stackIn;
    private final Stack<T> stackOut;

    public QueueAsStacks() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    // time complexity is O(n), where n is the current size of the Queue
    public void enqueue(T data){
        // make sure stackOut items are transferred to stackIn before adding more to stackIn
        while (!stackOut.isEmpty()){
            stackIn.push(stackOut.pop());
        }

        stackIn.push(data);
    }

    // time complexity is also O(n), where n is the current size of the Queue
    public T dequeue(){
        // make sure stackIn items are transferred to stackOut before removing from stackOut
        while (!stackIn.isEmpty()){
            stackOut.push(stackIn.pop());
        }

        if (!stackOut.isEmpty()){
            return stackOut.pop();
        }

        System.out.println("Queue is currently empty");
        return null;
    }

    public T peek(){
        // follows the same logic as dequeue()
        while (!stackIn.isEmpty()){
            stackOut.push(stackIn.pop());
        }

        if (!stackOut.isEmpty()){
            return stackOut.peek();
        }

        System.out.println("Queue is currently empty");
        return null;
    }

    public boolean isEmpty(){
        return stackIn.isEmpty() && stackOut.isEmpty();
    }
}
