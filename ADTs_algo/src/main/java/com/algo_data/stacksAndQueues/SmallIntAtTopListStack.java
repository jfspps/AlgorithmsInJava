package com.algo_data.stacksAndQueues;

import java.util.EmptyStackException;

public class SmallIntAtTopListStack extends ListStack<Integer> {

    private int smallestInt;
    private final ListStack<Integer> tempListStack;

    public SmallIntAtTopListStack() {
        super();
        tempListStack = new ListStack<>();
        smallestInt = Integer.MAX_VALUE;
    }

    public int getSmallestInt() {
        return smallestInt;
    }

    public ListStack<Integer> getTempStack() {
        return tempListStack;
    }

    // when pushing, one compares the topmost node with the incoming node
    // if top <= incoming data, then pop top to tempStack and then push incoming data
    // time complexity is either O(3) or O(1), so just O(1)
    /**
     * Pushes a new node to the stack and ensures the smallest integer is placed at the top
     * */
    public void push(int data){
        if (!super.isEmpty()) {
            if (super.peek() <= data) {
                // make way for incoming data
                tempListStack.push(super.pop());
                super.push(data);
                super.push(tempListStack.pop());    //tempStack is not always empty; see pop()
            } else {
                super.push(data);
                smallestInt = data;
            }
        } else {
            super.push(data);
            smallestInt = data;
        }
    }

    // when popping from stack, check if there are nodes beneath top that are smaller than top
    // time complexity is O(3n) or just O(n)
    /**
     * Removes and returns the smallest int from the stack or throws an EmptyStackException if empty
     * */
    public Integer pop(){
        if (super.isEmpty() && tempListStack.isEmpty()){
            System.out.println("Stack is empty");
            throw new EmptyStackException();
        }

        // transfer everything to tempStack
        while (!super.isEmpty()){
            tempListStack.push(super.pop());
        }

        // reset smallestInt and transfer one item
        smallestInt = tempListStack.peek();
        super.push(tempListStack.pop());

        // transfer all other items to stack, checking their values
        while (!tempListStack.isEmpty()){
            if (smallestInt > tempListStack.peek()){
                smallestInt = tempListStack.peek();
            }
            super.push(tempListStack.pop());
        }

        // transfer items to tempStack until an item with a value matching smallestInt is found (there may be >1 item)
        // this also means tempStack may not always be empty...
        while (!super.isEmpty()){
            if (super.peek() == smallestInt){
                break;
            }
            tempListStack.push(super.pop());
        }

        Integer output = super.pop();

        // ...return any tempStack nodes
        while (!tempListStack.isEmpty()){
            super.push(tempListStack.pop());
        }

        return output;
    }
}