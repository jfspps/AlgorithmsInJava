package com.algo_data.stacksAndQueues;

// a queue data structure implemented with two stacks
// stackIn is filled before item from enqueue(item) is added
// stackOut is filled before item from dequeue() is removed

public class QueueAsStacks<T> {

    // use the linked list implementation of a stack (stackSize not required on startup)
    private final ListStack<T> listStackIn;
    private final ListStack<T> listStackOut;

    public QueueAsStacks() {
        listStackIn = new ListStack<>();
        listStackOut = new ListStack<>();
    }

    // time complexity is O(n), where n is the current size of the Queue
    public void enqueue(T data){
        // make sure stackOut items are transferred to stackIn before adding more to stackIn
        while (!listStackOut.isEmpty()){
            listStackIn.push(listStackOut.pop());
        }

        listStackIn.push(data);
    }

    // time complexity is also O(n), where n is the current size of the Queue
    public T dequeue(){
        // make sure stackIn items are transferred to stackOut before removing from stackOut
        while (!listStackIn.isEmpty()){
            listStackOut.push(listStackIn.pop());
        }

        if (!listStackOut.isEmpty()){
            return listStackOut.pop();
        }

        System.out.println("Queue is currently empty");
        return null;
    }

    public T peek(){
        // follows the same logic as dequeue()
        while (!listStackIn.isEmpty()){
            listStackOut.push(listStackIn.pop());
        }

        if (!listStackOut.isEmpty()){
            return listStackOut.peek();
        }

        System.out.println("Queue is currently empty");
        return null;
    }

    public boolean isEmpty(){
        return listStackIn.isEmpty() && listStackOut.isEmpty();
    }
}
