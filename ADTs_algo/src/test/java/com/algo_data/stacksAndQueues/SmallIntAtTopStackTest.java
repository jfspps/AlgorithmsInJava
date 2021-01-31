package com.algo_data.stacksAndQueues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmallIntAtTopStackTest {

    SmallIntAtTopListStack stack;

    @BeforeEach
    void setUp() {
        stack = new SmallIntAtTopListStack();
    }

    @Test
    void push() {
        stack.push(4);
        assertFalse(stack.isEmpty());
    }

    @Test
    void pushSeveralInts() {
        for (int input : new int[]{2,3,4,5,0,3,12} ) {
            stack.push(input);
        }

        assertFalse(stack.isEmpty());
        assertEquals(0, stack.getSmallestInt());
    }

    @Test
    void pop() {
        stack.push(4);
        assertEquals(4, stack.pop());
    }

    @Test
    void popSeveral(){
        for (int input : new int[]{2,3,4,5,0,3,12} ) {
            stack.push(input);
        }

        assertEquals(0, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(3, stack.pop());
        assertEquals(3, stack.pop());
        assertEquals(4, stack.pop());

        // note that peek returns whatever is at the top of the stack and need not be the smallest int
        // use getSmallestInt() to peek at smallest int
        //
    }
}