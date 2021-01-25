package com.algo_data.stacksAndQueues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SetOfStacksTest {

    SetOfStacks<String> setOfStacks;
    String first = "first";
    String second = "second";
    String third = "third";
    ArrayStack<String> temp = new ArrayStack<>(2);

    @BeforeEach
    void setUp() {
        setOfStacks = new SetOfStacks<>(2);
    }

    @Test
    void getStacks() {
        assertNotNull(setOfStacks.getStacks());
        assertEquals(0, setOfStacks.getStacks().size());

        setOfStacks.getStacks().add(temp);
        assertEquals(1, setOfStacks.getStacks().size());
    }

    @Test
    void getStack() {
        setOfStacks.getStacks().add(temp);
        assertNotNull(setOfStacks.getStack(0));
    }

    @Test
    void stackIsEmpty() {
        setOfStacks.getStacks().add(temp);
        assertTrue(setOfStacks.getStack(0).isEmpty());
    }

    @Test
    void pushDefaults() {
        setOfStacks.push("Welcome!");
        assertFalse(setOfStacks.getStack(0).isEmpty());

        ArrayStack<String> arrayStack = setOfStacks.getStack(0);
        assertEquals("Welcome!", arrayStack.peek());
    }

    @Test
    void push(){
        setOfStacks.push("Welcome!", 2);
        assertFalse(setOfStacks.getStack(0).isEmpty());

        ArrayStack<String> arrayStack = setOfStacks.getStack(0);
        assertEquals("Welcome!", arrayStack.peek());
    }

    @Test
    void pushLotsSameStackSize(){
        setOfStacks.push(first, 2);
        setOfStacks.push(second, 2);
        setOfStacks.push(third, 2);
        assertFalse(setOfStacks.getStack(0).isEmpty());
        assertFalse(setOfStacks.getStack(1).isEmpty());
        assertNull(setOfStacks.getStack(2));

        ArrayStack<String> arrayStack = setOfStacks.getStack(0);
        assertEquals(second, arrayStack.peek());
        ArrayStack<String> arrayStack2 = setOfStacks.getStack(1);
        assertEquals(third, arrayStack2.peek());
    }

    @Test
    void pushLotsDifferentStackSize(){
        setOfStacks.push(first, 1);
        setOfStacks.push(second, 2);
        setOfStacks.push(third, 2);
        assertFalse(setOfStacks.getStack(0).isEmpty());
        assertFalse(setOfStacks.getStack(1).isEmpty());
        assertNull(setOfStacks.getStack(2));

        ArrayStack<String> arrayStack = setOfStacks.getStack(0);
        assertEquals(first, arrayStack.peek());
        ArrayStack<String> arrayStack2 = setOfStacks.getStack(1);
        assertEquals(third, arrayStack2.peek());
    }

    @Test
    void pop() {
        setOfStacks.push("Welcome!");
        assertEquals("Welcome!", setOfStacks.pop());
    }

    @Test
    void popMultipleStacks() {
        setOfStacks.push(first, 1);
        setOfStacks.push(second, 2);
        setOfStacks.push(third, 2);

        assertEquals(third, setOfStacks.pop());
        assertEquals(second, setOfStacks.pop());

        // second stack should now be null
        assertNull(setOfStacks.getStack(1));
    }

    @Test
    void popAt() {
        setOfStacks.push(first, 1);
        setOfStacks.push(second, 2);
        setOfStacks.push(third, 2);

        assertEquals(first, setOfStacks.popAt(0));
        assertNull(setOfStacks.getStack(0));
        assertNotNull(setOfStacks.getStack(1));
    }

    @Test
    void peek() {
        setOfStacks.push(first, 1);
        setOfStacks.push(second, 2);
        setOfStacks.push(third, 2);

        assertEquals(third, setOfStacks.peek());
    }

    @Test
    void peekAt() {
        setOfStacks.push(first, 1);
        setOfStacks.push(second, 2);
        setOfStacks.push(third, 2);

        assertEquals(third, setOfStacks.peekAt(1));
        assertEquals(first, setOfStacks.peekAt(0));
    }
}