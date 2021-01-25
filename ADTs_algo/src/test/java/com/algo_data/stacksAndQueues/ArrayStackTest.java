package com.algo_data.stacksAndQueues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {

    ArrayStack<String> stringArrayStack;
    String first;
    String second;

    @BeforeEach
    void setUp() {
        stringArrayStack = new ArrayStack<>(2);
        first = "first";
        second = "second";
        stringArrayStack.push(first);
        stringArrayStack.push(second);
    }

    @Test
    void pushToFullArray() {
        String temp = "tempElement";
        assertEquals(-1, stringArrayStack.push(temp));
    }

    @Test
    void pop() {
        assertEquals(second, stringArrayStack.pop());
        assertEquals(first, stringArrayStack.pop());
        assertThrows(EmptyStackException.class, () -> {
            stringArrayStack.pop();
        });
    }

    @Test
    void peek() {
        assertEquals(second, stringArrayStack.peek());
        assertNotEquals(first, stringArrayStack.peek());
    }

    @Test
    void peekAtEmptyStack() {
        assertEquals(second, stringArrayStack.pop());
        assertEquals(first, stringArrayStack.pop());
        assertThrows(EmptyStackException.class, () -> {
            stringArrayStack.peek();
        });
    }

    @Test
    void isEmpty() {
        assertFalse(stringArrayStack.isEmpty());
        stringArrayStack.pop();
        assertFalse(stringArrayStack.isEmpty());
        stringArrayStack.pop();
        assertTrue(stringArrayStack.isEmpty());
    }
}