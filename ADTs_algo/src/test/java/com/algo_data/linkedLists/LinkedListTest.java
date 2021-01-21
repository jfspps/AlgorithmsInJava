package com.algo_data.linkedLists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    LinkedList<Integer> integerLinkedList;
    LinkedList<Integer> integerLinkedListFromArray;
    LinkedList<Character> characterLinkedList;

    @BeforeEach
    void setUp() {
        integerLinkedList = new LinkedList<>(4);

        Integer[] intArray = { 1, 2, 3, 4, 5, 5, 4, 3, 2, 2, 2, 1, -8};
        integerLinkedListFromArray = new LinkedList<>(intArray);

        Character[] charArray = {'x', 'y', 'z'};
        characterLinkedList = new LinkedList<>(charArray);
    }

    @Test
    void length() {
        assertEquals(1, integerLinkedList.length());
        assertEquals(13, integerLinkedListFromArray.length());
        assertEquals(3, characterLinkedList.length());
    }

    @Test
    void getData(){
        //get the head node
        assertEquals('x', characterLinkedList.getData());
    }

    @Test
    void getNode() {
        // more general retrieval
        assertEquals(1, integerLinkedListFromArray.getNode(1).getData());
        assertEquals(4, integerLinkedList.getNode(4).getData());
        assertEquals('x', characterLinkedList .getNode('x').getData());

        assertNull(integerLinkedList.getNode(1));
        assertNull(integerLinkedListFromArray.getNode(16));
    }

    @Test
    void nodeIsPresent() {
        assertTrue(integerLinkedList.nodeIsPresent(integerLinkedList.getNode(4)));
        assertFalse(integerLinkedList.nodeIsPresent(integerLinkedList.getNode(5)));
        assertTrue(characterLinkedList.nodeIsPresent(characterLinkedList.getNode('y')));
        assertFalse(characterLinkedList.nodeIsPresent(characterLinkedList.getNode('A')));
    }

    @Test
    void getNodeList() {
        LinkedList<Integer>[] arrayOfOnes = integerLinkedListFromArray.getNodeList(1, 0);
        assertEquals(2, arrayOfOnes.length);

        LinkedList<Integer>[] arrayOfTens = integerLinkedListFromArray.getNodeList(10, 0);
        assertEquals(0, arrayOfTens.length);

        LinkedList<Character>[] arrayofXs = characterLinkedList.getNodeList('x', 0);
        assertEquals(1, arrayofXs.length);
    }

    @Test
    void appendOneNode() {
        integerLinkedList.append(26);
        assertEquals(2, integerLinkedList.length());
        assertEquals(26, integerLinkedList.getNode(26).getData());

        LinkedList<Character> nodeE = new LinkedList<>('E');
        characterLinkedList.append(nodeE);
        assertEquals(4, characterLinkedList.length());
        assertEquals('E', characterLinkedList.getNode('E').getData());
    }

    @Test
    void appendArrayOfNodes() {
        Integer[] newArray = { -1, -2, -3 };
        integerLinkedList.append(newArray);
        assertEquals(4, integerLinkedList.length());
        assertNotNull(integerLinkedList.getNode(-2));
    }

    @Test
    void insert() {
        integerLinkedListFromArray.insert(5, 0);
        assertTrue(integerLinkedListFromArray.nodeIsPresent(integerLinkedListFromArray.getNode(0)));
    }

    @Test
    void insertNode() {
        LinkedList<Integer> getFive = integerLinkedListFromArray.getNode(5);
        integerLinkedListFromArray.insert(getFive, 0);
        assertTrue(integerLinkedListFromArray.nodeIsPresent(integerLinkedListFromArray.getNode(0)));
    }

    @Test
    void deleteData() {
        integerLinkedListFromArray.deleteData(5);
        assertEquals(12, integerLinkedListFromArray.length());

        integerLinkedListFromArray.deleteData(5);
        assertEquals(11, integerLinkedListFromArray.length());
    }

    @Test
    void deleteHeadData() {
        integerLinkedListFromArray = integerLinkedListFromArray.deleteData(1);
        assertEquals(12, integerLinkedListFromArray.length());
        assertNotNull(integerLinkedListFromArray);

        // this is equivalent to deleting a tail
        integerLinkedList = integerLinkedList.deleteData(4);
        assertNull(integerLinkedList);
    }

    @Test
    void deleteAllWith() {
        integerLinkedListFromArray = integerLinkedListFromArray.deleteAllWith(5);
        assertEquals(11, integerLinkedListFromArray.length());
        assertNotNull(integerLinkedListFromArray);
    }

    @Test
    void deleteAllWith_head() {
        integerLinkedListFromArray = integerLinkedListFromArray.deleteAllWith(1);
        assertEquals(11, integerLinkedListFromArray.length());
        assertNotNull(integerLinkedListFromArray);
    }

    @Test
    void deleteAllWith_tail() {
        integerLinkedListFromArray = integerLinkedListFromArray.deleteAllWith(-8);
        assertEquals(12, integerLinkedListFromArray.length());
        assertNotNull(integerLinkedListFromArray);
    }

    @Test
    void deleteNode() {
        LinkedList<Integer> minusEight = integerLinkedListFromArray.getNode(-8);
        assertNotNull(minusEight);
        integerLinkedListFromArray = integerLinkedListFromArray.deleteNode(minusEight);
        assertEquals(12, integerLinkedListFromArray.length());
    }

    @Test
    void printToString() {
        String output = "Head: x, node 2: y, tail: z";
        assertEquals(output, characterLinkedList.printToString());
    }

    @Test
    void nodeToString() {
        assertEquals("Node not found in list", integerLinkedList.nodeToString(integerLinkedList.getNode(0)));
        assertEquals("z", characterLinkedList.nodeToString(characterLinkedList.getNode('z')));
        assertEquals("3", integerLinkedListFromArray.nodeToString(integerLinkedListFromArray.getNode(3)));
    }

    @Test
    void printRightPartition() {
        assertEquals("Node not found in list", integerLinkedList.printRightPartition(null));
        assertEquals("Right-hand partition is: 4; END", integerLinkedList.printRightPartition(integerLinkedList.getNode(4)));
        assertEquals("Right-hand partition is: 4, 5, 5, 4, 3, 2, 2, 2, 1, -8; END",
                integerLinkedListFromArray.printRightPartition(integerLinkedListFromArray.getNode(4)));
    }

    @Test
    void printLeftPartition() {
        assertEquals("Node not found in list", integerLinkedList.printLeftPartition(null));
        assertEquals("Left-hand partition is: 4; END", integerLinkedList.printLeftPartition(integerLinkedList.getNode(4)));
        assertEquals("Left-hand partition is: 1, 2, 3; END",
                integerLinkedListFromArray.printLeftPartition(integerLinkedListFromArray.getNode(4)));
    }
}