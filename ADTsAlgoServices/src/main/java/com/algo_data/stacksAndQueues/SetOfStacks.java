package com.algo_data.stacksAndQueues;

// handles a set of stacks and populates each each stack to its capacity before continuing the next stack
// use a linked list of arrays such that a longer linked list is actually in place but partitioned across a number of arrays
// requirements: pop() should remove items and automatically navigate between arrays until the entire list is empty
// and popAt() removes items from a specific stack

import com.algo_data.arrays.ArrayList;

import java.util.NoSuchElementException;

public class SetOfStacks<T> {

    private ArrayList<ArrayStack<T>> stacks;

    public SetOfStacks(int stackSize) {
        stacks = new ArrayList<>(stackSize);
    }

    public ArrayList<ArrayStack<T>> getStacks() {
        return stacks;
    }

    public ArrayStack<T> getStack(int index){
        return this.stacks.get(index);
    }

    public boolean stackIsEmpty(int index){
        return getStack(index).isEmpty();
    }

    /**
     * This pushes non-null data to a stack in a setOfStacks; a new stack of size stackSize is built if required
     * */
    public int push(T data, int stackSize){
        int index = 0;
        ArrayStack<T> currentStack = this.getStack(index);
        int returnType = -1;

        while (currentStack != null){
            // try to push to the currentStack
            returnType = currentStack.push(data);

            if (returnType == 1){
                break;
            }
            currentStack = this.getStack(++index);
        }

        if (returnType == -1){
            ArrayStack<T> newStack = new ArrayStack<>(stackSize);
            returnType = newStack.push(data);
            this.stacks.add(newStack);
        }

        return returnType;
    }

    /**
     * This pushes non-null data to a stack in a setOfStacks; a new stack of size 8 is built if required
     * */
    public int push(T data){
        return this.push(data, 8);
    }

    /**
     * Attempts to remove and return data (which can be null) from the most recent stack
     * */
    public T pop(){
        int latestStack = this.stacks.size() - 1;
        T output = this.stacks.get(latestStack).pop();

        if (this.stacks.get(latestStack).isEmpty()){
            this.stacks.removeAtIndex(latestStack);
        }

        return output;
    }

    /**
     * Attempts to remove and return data (which can be null) from the given stack
     * */
    public T popAt(int stackNumber){
        int latestStack = this.stacks.size() - 1;

        if (latestStack < stackNumber){
            throw new NoSuchElementException("Stack number provided not found");
        }
        T output = this.stacks.get(stackNumber).pop();

        if (this.stacks.get(stackNumber).isEmpty()){
            this.stacks.removeAtIndex(stackNumber);
        }

        return output;
    }

    /**
     * Attempts to return a copy of the data (which can be null) from the most recent stack
     * */
    public T peek(){
        int latestStack = this.stacks.size() - 1;
        return this.stacks.get(latestStack).peek();
    }

    /**
     * Attempts to return a copy of the data (which can be null) from the given stack
     * */
    public T peekAt(int stackNumber){
        int latestStack = this.stacks.size() - 1;

        if (latestStack < stackNumber){
            throw new NoSuchElementException("Stack number provided not found");
        }

        return this.stacks.get(stackNumber).peek();
    }
}
