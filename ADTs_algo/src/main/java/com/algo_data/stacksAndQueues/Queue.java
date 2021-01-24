package com.algo_data.stacksAndQueues;

import java.util.NoSuchElementException;

public class Queue<T> {

    // like the Stack class, a Queue is implemented with a linked list and accessed/viewed through public methods
    private static class QueueNode<T> {
        private T data;
        private QueueNode<T> next;

        public QueueNode(T data){
            this.data = data;
        }
    }

    // analogous in role to Stack's top property
    private QueueNode<T> first;
    private QueueNode<T> last;

    // adds a node
    public void enqueue(T item){
        QueueNode<T> newNode = new QueueNode<>(item);

        // add new item to the back of the queue
        if (last != null){
            last.next = newNode;
        }

        last = newNode;

        // account for a new queue by setting first to newNode
        if (first == null) {
            first = last;
        }
    }

    // remove a node
    public T dequeue(){
        if (first == null){
            throw new NoSuchElementException();
        }

        //get the first item's data and then update the queue
        T data = first.data;
        first = first.next;

        // if the queue is empty, then update last
        if (first == null){
            last = null;
        }
        return data;
    }

    // view the first node
    public T peek(){
        if (first == null){
            throw new NoSuchElementException();
        }
        return first.data;
    }

    // check if queue is empty or not
    public boolean isEmpty(){
        return first == null;
    }
}
