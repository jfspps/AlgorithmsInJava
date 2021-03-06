package com.algo_data.treesAndGraphs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.Inet4Address;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    BinaryTree<Integer> binaryTree;
    BinaryTree<Integer> leftChild;
    BinaryTree<Integer> rightChild;

    BinaryTree<Integer> leftLeftChild;

    @BeforeEach
    void setUp() {
        binaryTree = new BinaryTree<>(4);
        leftChild = new BinaryTree<>(2);
        rightChild = new BinaryTree<>(6);

        leftLeftChild = new BinaryTree<>(1);
        binaryTree.setLeftChild(leftChild);
        binaryTree.setRightChild(rightChild);

        binaryTree.getLeftChild().setLeftChild(leftLeftChild);
    }

    @Test
    void inOrderTraversal() {
        StringBuilder stringBuilder = new StringBuilder();
        binaryTree.inOrderTraversal(binaryTree, stringBuilder);

        String output = stringBuilder.toString();
        String expected = "1 2 4 6 ";

        assertEquals(expected, output);
    }

    @Test
    void preOrderTraversal() {
        StringBuilder stringBuilder = new StringBuilder();
        binaryTree.preOrderTraversal(binaryTree, stringBuilder);

        String output = stringBuilder.toString();
        String expected = "4 2 1 6 ";

        assertEquals(expected, output);
    }

    @Test
    void postOrderTraversal() {
        StringBuilder stringBuilder = new StringBuilder();
        binaryTree.postOrderTraversal(binaryTree, stringBuilder);

        String output = stringBuilder.toString();
        String expected = "1 2 6 4 ";

        assertEquals(expected, output);
    }

    @Test
    void levelOrderTraversal() {
        StringBuilder stringBuilder = new StringBuilder();
        binaryTree.levelOrderTraversal(binaryTree, stringBuilder);

        String output = stringBuilder.toString();
        String expected = "4 2 6 1 ";

        assertEquals(expected, output);
    }

    @Test
    void levelOrderReversedTraversal() {
        StringBuilder stringBuilder = new StringBuilder();
        binaryTree.levelOrderReversedTraversal(binaryTree, stringBuilder);

        String output = stringBuilder.toString();
        String expected = "4 6 2 1 ";

        assertEquals(expected, output);
    }

    @Test
    void getMaxDepth() {
        assertEquals(3, binaryTree.getMaxDepth(binaryTree));
    }

    @Test
    void getShortestDepth() {
        assertEquals(2, binaryTree.getShortestDepth(binaryTree));
    }

    @Test
    void listIsBST() {
        LinkedList<Integer> outputList = new LinkedList<>();
        outputList.addAll(List.of(1, 2, 4, 6));

        assertTrue(binaryTree.checkIfBST(outputList));
    }

    @Test
    void isABinarySearchTree() {
        LinkedList<Integer> outputList = new LinkedList<>();

        assertTrue(binaryTree.isABinarySearchTree(binaryTree, outputList));
    }
}