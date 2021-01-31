package com.algo_data.stacksAndQueues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueAsStacksTest {

    QueueAsStacks<Character> queue;
    Character[] characters = {'a','b','c'};

    @BeforeEach
    void setUp() {
        queue = new QueueAsStacks<>();
    }

    @Test
    void enqueue() {
        queue.enqueue('A');
        assertFalse(queue.isEmpty());
    }

    @Test
    void dequeue() {
        queue.enqueue('A');
        assertEquals('A', queue.dequeue());
    }

    @Test
    void dequeueList() {
        for (Character character: characters) {
            queue.enqueue(character);
        }
        assertEquals('a', queue.dequeue());
        assertEquals('b', queue.dequeue());
        assertEquals('c', queue.dequeue());

    }

    @Test
    void peek() {
        for (Character character: characters) {
            queue.enqueue(character);
        }
        assertEquals('a', queue.peek());
    }

    @Test
    void isEmpty() {
        assertTrue(queue.isEmpty());
    }
}