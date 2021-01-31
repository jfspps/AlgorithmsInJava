package com.algo_data.linkedLists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListsIntersectTest {

    LinkedList<Integer> integerLinkedList1;
    LinkedList<Integer> integerLinkedList2;

    LinkedList<Integer> equalLengthList;
    LinkedList<Integer> unequalLengthList;

    ListsIntersect<Integer> listsIntersect;

    @BeforeEach
    void setUp() {
        integerLinkedList1 = new LinkedList<>(new Integer[]{1, 2, 3, 4, 5, 6});
        integerLinkedList2 = new LinkedList<>(new Integer[]{10, 11});

        equalLengthList = integerLinkedList1.getNode(3);
        unequalLengthList = integerLinkedList1.getNode(5);
    }

    @Test
    void listsIntersect_Even() {
        // join both at list1's node(3)
        integerLinkedList2.append(equalLengthList);

        listsIntersect = new ListsIntersect<>(integerLinkedList1);
        assertTrue(listsIntersect.listsIntersect(integerLinkedList2));
        assertEquals(3, listsIntersect.getIntersection(integerLinkedList2).getData());
    }

    @Test
    void listsIntersect_Odd() {
        // join both at list1's node(5)
        integerLinkedList2.append(unequalLengthList);

        listsIntersect = new ListsIntersect<>(integerLinkedList1);
        assertTrue(listsIntersect.listsIntersect(integerLinkedList2));
        assertEquals(5, listsIntersect.getIntersection(integerLinkedList2).getData());
    }

    @Test
    void listsDoNotIntersect() {
        listsIntersect = new ListsIntersect<>(integerLinkedList1);
        assertFalse(listsIntersect.listsIntersect(integerLinkedList2));
    }
}