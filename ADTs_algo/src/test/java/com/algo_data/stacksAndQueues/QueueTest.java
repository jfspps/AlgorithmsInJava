package com.algo_data.stacksAndQueues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    Queue<String> stringQueue;
    String first;
    String second;

    @BeforeEach
    void setUp() {
        first = "first";
        second = "second";
        stringQueue = new Queue<>();
        stringQueue.enqueue(first);
        stringQueue.enqueue(second);
    }

    @Test
    void enqueueAndDequeue() {
        assertEquals(first, stringQueue.dequeue());
        assertEquals(second, stringQueue.dequeue());
        assertThrows(NoSuchElementException.class, () -> {
            stringQueue.dequeue();
        });
    }

    @Test
    void peek() {
        assertEquals(first, stringQueue.peek());
        assertNotEquals(second, stringQueue.dequeue());
    }

    @Test
    void peekAtEmptyQueue() {
        assertEquals(first, stringQueue.dequeue());
        assertEquals(second, stringQueue.dequeue());
        assertThrows(NoSuchElementException.class, () -> {
            stringQueue.peek();
        });
    }

    @Test
    void isEmpty() {
        assertFalse(stringQueue.isEmpty());
        stringQueue.dequeue();
        assertFalse(stringQueue.isEmpty());
        stringQueue.dequeue();
        assertTrue(stringQueue.isEmpty());
    }
}