package com.algo_data.linkedLists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindKthToLastTest {

    LinkedList<Integer> list;
    FindKthToLast<Integer> findKthToLast;

    @BeforeEach
    void setUp() {
        Integer[] integers = {1, 2, 2, 3, 4, 5, 5, 5, 6, 8};
        list = new LinkedList<>(integers);
        findKthToLast = new FindKthToLast<>(list);
    }

    @Test
    void findKthToLast() {
        LinkedList<Integer> last = findKthToLast.findKthToLast(1);
        LinkedList<Integer> third = findKthToLast.findKthToLast(3);
        LinkedList<Integer> outOfBounds = findKthToLast.findKthToLast(list.length()+1);
        LinkedList<Integer> firstNode = findKthToLast.findKthToLast(list.length());

        assertEquals(8, last.getData());
        assertEquals(5, third.getData());
        assertNull(outOfBounds);
        assertEquals(1, firstNode.getData());
    }
}