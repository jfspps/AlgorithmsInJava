package com.algo_data.stacksAndQueues;

import java.util.EmptyStackException;

// array implementation of a stack
public class ArrayOfThreeStacks<T> {

    // Java would use boxed types (Integer, String, Character)
    // approach by storing items in an array, where the top item/node is updated after each method

    private final int stack1Size;
    private final int stack2Size;
    private final int stack3Size;
    private final T[] stackArray;
    private int stack1topIndex;
    private int stack2topIndex;
    private int stack3topIndex;

    public ArrayOfThreeStacks(int stack1Size, int stack2Size, int stack3Size){
        //care needed to keep this execution away from client code until T is known
        this.stack1Size = stack1Size;
        this.stack2Size = stack2Size;
        this.stack3Size = stack3Size;

        this.stackArray = (T[]) new Object[this.stack1Size + this.stack2Size + this.stack3Size];
        this.stack1topIndex = -1;
        this.stack2topIndex = stack1topIndex + stack1Size;
        this.stack3topIndex = stack2topIndex + stack2Size;
    }

    /**
     * Pushes a new element or node (the data of which can be null) to the top of the given stack.
     * New nodes' data can be null hence pop() and peek() return null if the data is null and throw exceptions when
     * the given stack is empty. This method attempts to push to the given stack and automatically attempts to push to
     * consecutive stack(s) if the current stack is full. Returns a copy of the data if pushed and null if stack
     * parameter is invalid.
     * */
    public T push(T data, int stackNumber){
        if (!stackNumberIsValid(stackNumber)) return null;

        int flag;

        //establish which stack to process
        if (stackNumber == 1){
            flag = pushToStack(1, data);
        } else if (stackNumber == 2){
            flag = pushToStack(2, data);
        } else
            flag = pushToStack(3, data);

        if (flag == 1){
            return data;
        } else
            return null;
    }

    private boolean stackNumberIsValid(int stackNumber) {
        if (stackNumber < 1 || stackNumber > 3) {
            System.out.println("Stack number of 1, 2 or 3 required");
            return false;
        }
        return true;
    }

    // returns -1 is stack paramter is invalid, 0 if stacks are full and 1 if push is successful
    private int pushToStack(int stack, T data) {
        if (!stackNumberIsValid(stack)) return -1;

        if (this.isFull(stack)){
            System.out.println("Stack " + stack + " is full, cannot push data to stack " + stack);

            if (++stack > 3){
                System.out.println("All stacks are full");
                return 0;
            }

            //try the next stack
            int flag = (pushToStack(stack, data));
            if (flag == 1){
                return 1;
            } else {
                return 0;
            }
        }

        if (stack == 1){
            this.stackArray[++stack1topIndex] = data;
        } else if (stack == 2){
            this.stackArray[++stack2topIndex] = data;
        } else
            this.stackArray[++stack3topIndex] = data;

        return 1;
    }

    /**
     * Returns true if the given stack is full and false if not
     * */
    private boolean isFull(int stack){
        if (stack == 1){
            return stack1topIndex == stack1Size -1;
        } else if (stack == 2){
            return stack2topIndex == stack1Size + stack2Size -1;
        } else
            return stack3topIndex == stack1Size + stack2Size + stack3Size -1;
    }

    /**
     * Removes and returns the uppermost node's or element's data from the given stack. Returns null if stack parameter
     * is invalid and throws an EmptyStackException if stack is empty.
     * */
    public T pop(int stack){
        if (!stackNumberIsValid(stack)) return null;

        if (isEmpty(stack)){
            System.out.println("Stack " + stack + " is empty");
            throw new EmptyStackException();
        }

        T temp;
        if (stack == 1){
            temp = this.stackArray[stack1topIndex--];
        } else if (stack ==  2){
            temp = this.stackArray[stack2topIndex--];
        } else {
            temp = this.stackArray[stack3topIndex--];
        }
        return temp;
    }

    /**
     * Returns a copy of the uppermost node (which can be null) or element of the given stack.
     * Returns null if stack parameter is invalid. Throws an EmptyStackException if stack is empty.
     * */
    public T peek(int stack){
        if (!stackNumberIsValid(stack)) return null;

        if (this.isEmpty(stack)) throw new EmptyStackException();

        if (stack == 1){
            return this.stackArray[stack1topIndex];
        } else if (stack == 2){
            return this.stackArray[stack2topIndex];
        } else
            return this.stackArray[stack3topIndex];
    }

    /**
     * Returns true if the given stack is empty and false if not
     * */
    public boolean isEmpty(int stack){
        if (!stackNumberIsValid(stack)) return false;

        if (stack == 1){
            return this.stack1topIndex < 0;
        } else if (stack == 2){
            return this.stack2topIndex < this.stack1Size;
        } else
            return this.stack3topIndex < (this.stack1Size + this.stack2Size);
    }
}
