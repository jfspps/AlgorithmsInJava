package com.algo_data.treesAndGraphs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.naming.directory.SearchControls;

import static org.junit.jupiter.api.Assertions.*;

class SearchableTreeTest {

    private final SearchableTree<Integer> root = new SearchableTree<>(44);
    private final SearchableTree<Integer> leftChild = new SearchableTree<>(31);
    private final SearchableTree<Integer> middleChild = new SearchableTree<>(55);
    private final SearchableTree<Integer> rightChild = new SearchableTree<>(67);

    private final SearchableTree<Integer> leftLeftChild = new SearchableTree<>(100);
    private final SearchableTree<Integer> leftRightChild = new SearchableTree<>(150);

    private final SearchableTree<Integer> rightChildChild = new SearchableTree<>(99);

    @BeforeEach
    void setUp() {
        root.setAdjacent(new SearchableTree[]{leftChild, middleChild, rightChild});
        leftChild.setAdjacent(new SearchableTree[]{root, leftLeftChild, leftRightChild, middleChild});
        middleChild.setAdjacent(new SearchableTree[]{root, leftChild, rightChild});
        rightChild.setAdjacent(new SearchableTree[]{root, middleChild, rightChildChild});

        leftLeftChild.setAdjacent(new SearchableTree[]{leftChild, leftRightChild});
        leftRightChild.setAdjacent(new SearchableTree[]{leftChild, leftLeftChild});
        rightChildChild.setAdjacent(new SearchableTree[]{rightChild});
    }

    @Test
    void depthFirstSearch() {
        // should be 44, 31, 100, 150, 55, 67, 99
        assertEquals("44 31 100 150 55 67 99 ", root.depthFirstSearch(root, new StringBuilder()));
    }

    @Test
    void breadthFirstSearch() {
        // should be 44, 31, 55, 67, 100, 150, 99
        assertEquals("44 31 55 67 100 150 99 ", root.breadthFirstSearch(root, new StringBuilder()));
    }
}