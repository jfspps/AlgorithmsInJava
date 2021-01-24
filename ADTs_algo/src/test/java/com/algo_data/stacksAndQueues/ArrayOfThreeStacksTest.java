package com.algo_data.stacksAndQueues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayOfThreeStacksTest {

    ArrayOfThreeStacks<String> arrayOfThreeStacks;
    String first;
    String second;
    String third;

    @BeforeEach
    void setUp() {
        arrayOfThreeStacks = new ArrayOfThreeStacks<>(2, 2, 3);
        first = "first";
        second = "second";
        third = "third";
    }

    @Test
    void pushAndIsEmpty() {
        arrayOfThreeStacks.push(first, 1);
        assertFalse(arrayOfThreeStacks.isEmpty(1));
        assertTrue(arrayOfThreeStacks.isEmpty(2));
        assertTrue(arrayOfThreeStacks.isEmpty(3));
    }

    @Test
    void pop() {
        arrayOfThreeStacks.push(first, 1);
        assertEquals(first, arrayOfThreeStacks.pop(1));
        assertNull(arrayOfThreeStacks.pop(2));
        assertNull(arrayOfThreeStacks.pop(3));
    }

    @Test
    void peek() {
        arrayOfThreeStacks.push(first, 1);
        assertEquals(first, arrayOfThreeStacks.peek(1));
        assertNull(arrayOfThreeStacks.peek(2));
        assertNull(arrayOfThreeStacks.peek(3));
    }

    @Test
    void pushToDifferentStacks(){
        arrayOfThreeStacks.push(first, 1);
        arrayOfThreeStacks.push(second, 2);
        arrayOfThreeStacks.push(third, 3);

        assertEquals(first, arrayOfThreeStacks.peek(1));
        assertEquals(second, arrayOfThreeStacks.peek(2));
        assertEquals(third, arrayOfThreeStacks.peek(3));

        assertEquals(first, arrayOfThreeStacks.pop(1));
        assertEquals(second, arrayOfThreeStacks.pop(2));
        assertEquals(third, arrayOfThreeStacks.pop(3));

        assertTrue(arrayOfThreeStacks.isEmpty(1));
        assertTrue(arrayOfThreeStacks.isEmpty(2));
        assertTrue(arrayOfThreeStacks.isEmpty(3));
    }

    @Test
    void overFlowToNextStack(){
        arrayOfThreeStacks.push(first, 1);
        arrayOfThreeStacks.push(second, 1);
        arrayOfThreeStacks.push(third, 1);

        assertEquals(second, arrayOfThreeStacks.peek(1));
        assertEquals(third, arrayOfThreeStacks.peek(2));

        assertEquals(second, arrayOfThreeStacks.pop(1));
        assertEquals(first, arrayOfThreeStacks.pop(1));
        assertEquals(third, arrayOfThreeStacks.pop(2));

        assertTrue(arrayOfThreeStacks.isEmpty(1));
        assertTrue(arrayOfThreeStacks.isEmpty(2));
        assertTrue(arrayOfThreeStacks.isEmpty(3));
    }
}