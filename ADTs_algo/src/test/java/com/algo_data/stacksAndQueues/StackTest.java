package com.algo_data.stacksAndQueues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    Stack<String> stringStack;
    String first;
    String second;

    @BeforeEach
    void setUp() {
        stringStack = new Stack<>();
        first = "first";
        second = "second";
        stringStack.push(first);
        stringStack.push(second);
    }

    @Test
    void pop() {
        assertEquals(second, stringStack.pop());
        assertEquals(first, stringStack.pop());
        assertThrows(EmptyStackException.class, () -> {
            stringStack.pop();
        });
    }

    @Test
    void push() {
        String temp = "tempElement";
        stringStack.push(temp);
        assertEquals(temp, stringStack.pop());
    }

    @Test
    void peek() {
        assertEquals(second, stringStack.peek());
        assertNotEquals(first, stringStack.peek());
    }

    @Test
    void isEmpty() {
        assertFalse(stringStack.isEmpty());
        stringStack.pop();
        assertFalse(stringStack.isEmpty());
        stringStack.pop();
        assertTrue(stringStack.isEmpty());
    }
}