package com.algo_data.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayListTest {

    CustomArrayList<Integer> testIntArray;
    CustomArrayList<Integer> builtArray;

    @BeforeEach
    void setUp() {
        testIntArray = new CustomArrayList<>(5);
        builtArray = new CustomArrayList<>(10);
        builtArray.add(1);
        builtArray.add(2);
        builtArray.add(3);
        builtArray.add(4);
        builtArray.add(5);
    }

    @Test
    void add() {
        testIntArray.add(1);
        assertEquals(1, testIntArray.size());
    }

    @Test
    void addSeveral() {
        testIntArray.add(1);
        testIntArray.add(2);
        testIntArray.add(3);
        testIntArray.add(4);
        testIntArray.add(5);
        assertEquals(5, testIntArray.size());
    }

    @Test
    void size() {
        assertNotEquals(100, builtArray.size());
        assertEquals(5, builtArray.size());
    }

    @Test
    void isEmpty() {
        assertTrue(testIntArray.isEmpty());
        assertFalse(builtArray.isEmpty());
    }

    @Test
    void get() {
        assertEquals(2, builtArray.get(1));
        assertNotEquals(0, builtArray.get(0));
    }

    @Test
    void clear() {
        builtArray.clear();
        assertEquals(0, builtArray.size());
        assertNull(builtArray.get(0));
        assertNull(builtArray.get(1));
        assertNull(builtArray.get(2));
        assertNull(builtArray.get(3));
        assertNull(builtArray.get(4));
    }

    @Test
    void indexOf() {
        assertEquals(2, builtArray.indexOf(3));
    }

    @Test
    void removeElement() {
        // indices are 0 to 4, the element values are 1 to 5
        Integer found = builtArray.removeElement(3);
        assertNull(builtArray.get(2));
        assertEquals(3, found);
    }

    @Test
    void removeAtIndex() {
        Integer found = builtArray.removeAtIndex(3);
        assertNull(builtArray.get(3));
        assertEquals(4, found);
    }

    @Test
    void set() {
        builtArray.set(99, 2);
        assertEquals(99, builtArray.get(2));
    }

    @Test
    void setOutOfBounds() {
        builtArray.set(99, 25);
        assertEquals(99, builtArray.get(25));
        assertNull(builtArray.get(14));
    }
}