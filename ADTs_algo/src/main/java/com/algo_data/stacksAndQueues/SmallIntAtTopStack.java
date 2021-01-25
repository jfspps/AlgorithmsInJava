package com.algo_data.stacksAndQueues;

import java.util.EmptyStackException;

public class SmallIntAtTopStack extends Stack<Integer> {

    private int smallestInt;
    private final Stack<Integer> tempStack;

    public SmallIntAtTopStack() {
        super();
        tempStack = new Stack<>();
        smallestInt = Integer.MAX_VALUE;
    }

    public int getSmallestInt() {
        return smallestInt;
    }

    public Stack<Integer> getTempStack() {
        return tempStack;
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
                tempStack.push(super.pop());
                super.push(data);
                super.push(tempStack.pop());    //tempStack is not always empty; see pop()
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
        if (super.isEmpty() && tempStack.isEmpty()){
            System.out.println("Stack is empty");
            throw new EmptyStackException();
        }

        // transfer everything to tempStack
        while (!super.isEmpty()){
            tempStack.push(super.pop());
        }

        // reset smallestInt and transfer one item
        smallestInt = tempStack.peek();
        super.push(tempStack.pop());

        // transfer all other items to stack, checking their values
        while (!tempStack.isEmpty()){
            if (smallestInt > tempStack.peek()){
                smallestInt = tempStack.peek();
            }
            super.push(tempStack.pop());
        }

        // transfer items to tempStack until an item with a value matching smallestInt is found (there may be >1 item)
        // this also means tempStack may not always be empty...
        while (!super.isEmpty()){
            if (super.peek() == smallestInt){
                break;
            }
            tempStack.push(super.pop());
        }

        Integer output = super.pop();

        // ...return any tempStack nodes
        while (!tempStack.isEmpty()){
            super.push(tempStack.pop());
        }

        return output;
    }
}