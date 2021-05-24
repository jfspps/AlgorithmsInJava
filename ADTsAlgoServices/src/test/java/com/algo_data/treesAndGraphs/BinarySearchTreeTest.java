package com.algo_data.treesAndGraphs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    private final Integer[] integers = {1, 3, 5, 7, 8, 9, 10};
    private BinarySearchTree binarySearchTree;

    @BeforeEach
    void setUp() {
        binarySearchTree = new BinarySearchTree(null).buildBinarySearchTree(integers);
    }

    @Test
    void buildLinkedListOfEachLevel() {
        ArrayList<LinkedList<BinaryTree<Integer>>> list = new ArrayList<>();

        binarySearchTree.buildLevelLinkedList(binarySearchTree, list, 0);
        // note the level includes the root node (for non-null BSTs, level > 0)
        assertEquals(3, list.size());
    }

    @Test
    void getNode() {
        BinarySearchTree found = binarySearchTree.getNode(binarySearchTree, 5);
        assertEquals(5, found.getData());
    }

    @Test
    void getNode_false() {
        BinarySearchTree found = binarySearchTree.getNode(binarySearchTree, 11);
        assertNull(found);
    }

    @Test
    void getNextInOrder() {
        BinarySearchTree nextNode = binarySearchTree.getNextInOrder(binarySearchTree);
        assertEquals(8, nextNode.getData());
    }

    @Test
    void getNextInOrder_false() {
        BinarySearchTree nextNode = binarySearchTree.getNextInOrder(binarySearchTree);
        assertNotEquals(1, nextNode.getData());
    }
}