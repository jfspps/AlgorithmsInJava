package com.algo_data.linkedLists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesTest {

    LinkedList<Integer> integerLinkedList;
    RemoveDuplicates<Integer> removeDuplicates;

    @BeforeEach
    void setup(){
        Integer[] integers = {1, 2, 2, 3, 4, 5, 5, 5, 6, 8};
        integerLinkedList = new LinkedList<>(integers);
        removeDuplicates = new RemoveDuplicates<>(integerLinkedList);
    }

    @Test
    void removeDuplicatesWithTally() {
        removeDuplicates.removeDuplicatesWithTally();
        System.out.println(integerLinkedList.printToString());
        assertEquals(7, integerLinkedList.length());
    }

    @Test
    void removeDuplicatesWithoutTally() {
        removeDuplicates.removeDuplicatesWithoutTally();
        System.out.println(integerLinkedList.printToString());
        assertEquals(7, integerLinkedList.length());
    }
}