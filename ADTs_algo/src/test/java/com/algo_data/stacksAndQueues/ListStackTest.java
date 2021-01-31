package com.algo_data.stacksAndQueues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class ListStackTest {

    ListStack<String> stringListStack;
    String first;
    String second;

    @BeforeEach
    void setUp() {
        stringListStack = new ListStack<>();
        first = "first";
        second = "second";

        stringListStack.push(first);
        stringListStack.push(second);
    }

    @Test
    void pop() {
        assertEquals(second, stringListStack.pop());
        assertEquals(first, stringListStack.pop());
        assertThrows(EmptyStackException.class, () -> {
            stringListStack.pop();
        });
    }

    @Test
    void peek() {
        assertEquals(second, stringListStack.peek());
        assertNotEquals(first, stringListStack.peek());
    }

    @Test
    void isEmpty() {
        assertFalse(stringListStack.isEmpty());
        stringListStack.pop();
        assertFalse(stringListStack.isEmpty());
        stringListStack.pop();
        assertTrue(stringListStack.isEmpty());
    }
}