package com.algo_data.stacksAndQueues;

public class ArrayStackWithMin extends ArrayStack<Integer>{

    // Build a stack as an array of Integers along with another stack which keeps track of minima
    // Both ArrayStack and stackOfMinima must be in sync
    // when a new min value is pushed to ArrayStack, push the same value to stackOfMinima
    // when the min value has been removed (popped), pop the same value from stackOfMinima
    // note that stackOfMinima only changes when there is a change to the minimum of ArrayStack nodes

    ArrayStack<Integer> stackOfMinima;

    public ArrayStackWithMin(int stackSize){
        super(stackSize);
        stackOfMinima = new ArrayStack<>(stackSize);
    }

    /**
     * Retrieves the new minimum int as each node from ArrayStack is pushed or popped
     * */
    public int getMinimum(){
        if (stackOfMinima.isEmpty()){
            return Integer.MAX_VALUE;
        }

        //retrieve the current minimum of ArrayStack from its complementary stackOfMinima
        return stackOfMinima.peek();
    }

    /**
     * Pushed the new value to the stack and updates the stackOfMinima if the pushed value is the new minimum.
     * Returns -1 if stack is full and 1 is push succeeded.
     * */
    public int push(Integer value){
        if (value <= getMinimum()){
            // update stackOfMinima with the new min
            stackOfMinima.push(value);
        }

        // then push value to ArrayStack
        return super.push(value);
    }

    /**
     * Removes and returns the uppermost node from ArrayStack and if node holds the minimum Integer, then pop() removes
     * current minimum from stackOfMinima
     * */
    public Integer pop(){
        Integer arrayStackData = super.pop();

        // update stackOfMinima if required
        if (arrayStackData == getMinimum()){
            stackOfMinima.pop();
        }

        return arrayStackData;
    }
}