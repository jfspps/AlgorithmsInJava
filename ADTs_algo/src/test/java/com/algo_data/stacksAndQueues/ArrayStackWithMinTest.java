package com.algo_data.stacksAndQueues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackWithMinTest {

    Integer[] integers = {5, 4, 6, 1, 5, 3, 8, 9, 10, 2};
    ArrayStackWithMin stackWithMin;

    @BeforeEach
    void setUp() {
        stackWithMin = new ArrayStackWithMin(integers.length + 3);
        for (Integer data : integers) {
            stackWithMin.push(data);
        }
    }

    @Test
    void getMinimum() {
        assertEquals(1, stackWithMin.getMinimum());
    }

    @Test
    void push() {
        assertEquals(12, stackWithMin.push(12));
        assertEquals(1, stackWithMin.getMinimum());
    }

    @Test
    void pop() {
        assertEquals(2, stackWithMin.pop());
        assertEquals(1, stackWithMin.getMinimum());
    }
}