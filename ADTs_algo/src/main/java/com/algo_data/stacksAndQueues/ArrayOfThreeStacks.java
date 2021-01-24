package com.algo_data.stacksAndQueues;

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

    public void push(T data, int stackNumber){
        if (parameterIsOutOfBounds(stackNumber)) return;

        //establish which stack to process
        if (stackNumber == 1){
            pushToStack(1, data);
        } else if (stackNumber == 2){
            pushToStack(2, data);
        } else
            pushToStack(3, data);
    }

    private boolean parameterIsOutOfBounds(int stackNumber) {
        if (stackNumber < 1 || stackNumber > 3) {
            System.out.println("Stack number of 1, 2 or 3 required");
            return true;
        }
        return false;
    }

    private void pushToStack(int i, T data) {
        if (parameterIsOutOfBounds(i)) return;

        if (this.isFull(i)){
            System.out.println("Stack " + i + " is full, cannot push item to stack " + i);
            pushToStack(++i, data);
            return;
        }

        if (i == 1){
            this.stackArray[++stack1topIndex] = data;
        } else if (i == 2){
            this.stackArray[++stack2topIndex] = data;
        } else
            this.stackArray[++stack3topIndex] = data;

        System.out.println("Data pushed to stack " + i);
    }

    private boolean isFull(int i){
        if (i == 1){
            return stack1topIndex == stack1Size -1;
        } else if (i == 2){
            return stack2topIndex == stack1Size + stack2Size -1;
        } else
            return stack3topIndex == stack1Size + stack2Size + stack3Size -1;
    }

    public T pop(int stackNumber){
        if (parameterIsOutOfBounds(stackNumber)) return null;

        if (isEmpty(stackNumber)){
            System.out.println("Stack " + stackNumber + " is empty");
            return null;
        }

        T temp;
        if (stackNumber == 1){
            temp = this.stackArray[stack1topIndex--];
        } else if (stackNumber ==  2){
            temp = this.stackArray[stack2topIndex--];
        } else {
            temp = this.stackArray[stack3topIndex--];
        }
        return temp;
    }

    public T peek(int stackNumber){
        if (parameterIsOutOfBounds(stackNumber)) return null;

        if (stackNumber == 1){
            return this.stackArray[stack1topIndex];
        } else if (stackNumber == 2){
            return this.stackArray[stack2topIndex];
        } else
            return this.stackArray[stack3topIndex];
    }

    public boolean isEmpty(int stackNumber){
        if (parameterIsOutOfBounds(stackNumber)) return false;

        if (stackNumber == 1){
            return this.stack1topIndex < 0;
        } else if (stackNumber == 2){
            return this.stack2topIndex < this.stack1Size;
        } else
            return this.stack3topIndex < (this.stack1Size + this.stack2Size);
    }
}
