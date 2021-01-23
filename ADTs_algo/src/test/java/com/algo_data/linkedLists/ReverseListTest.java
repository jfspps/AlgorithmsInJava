package com.algo_data.linkedLists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseListTest {

    LinkedList<Integer> integerLinkedListFromArray;
    LinkedList<Character> characterLinkedList;
    ReverseList<Integer> integerReverseList;
    ReverseList<Character> characterReverseList;

    @BeforeEach
    void setUp() {
        Integer[] intArray = { 1, 2, 3, 4, 5, 5, 4, 3, 2, 2, 2, 1, -8};
        integerLinkedListFromArray = new LinkedList<>(intArray);
        integerReverseList = new ReverseList<>(integerLinkedListFromArray);

        Character[] charArray = {'w', 'x', 'y', 'z'};
        characterLinkedList = new LinkedList<>(charArray);
        characterReverseList = new ReverseList<>(characterLinkedList);
    }

    @Test
    void reverseList() {
        String charOutput = "(Head) z, y, x, w (Tail)";
        String intOutput = "(Head) -8, 1, 2, 2, 2, 3, 4, 5, 5, 4, 3, 2, 1 (Tail)";

        assertEquals(charOutput, characterReverseList.reverseList().printToString());
        assertEquals(intOutput, integerReverseList.reverseList().printToString());
    }

    @Test
    void reverseListUptoK() {
        LinkedList<Integer> nodeFour = integerLinkedListFromArray.getNode(4);
        LinkedList<Character> nodeZ = characterLinkedList.getNode('z');

        String charOutput = "(Head) y, x, w (Tail)";
        String intOutput = "(Head) 3, 2, 1 (Tail)";

        assertEquals(charOutput, characterReverseList.reverseListUpToK(nodeZ).printToString());
        assertEquals(intOutput, integerReverseList.reverseListUpToK(nodeFour).printToString());
    }
}