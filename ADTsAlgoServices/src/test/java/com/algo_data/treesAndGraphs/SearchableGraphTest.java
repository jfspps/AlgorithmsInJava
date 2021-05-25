package com.algo_data.treesAndGraphs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchableGraphTest {

    private final SearchableGraph<Integer> root = new SearchableGraph<>(44);
    private final SearchableGraph<Integer> leftChild = new SearchableGraph<>(31);
    private final SearchableGraph<Integer> middleChild = new SearchableGraph<>(55);
    private final SearchableGraph<Integer> rightChild = new SearchableGraph<>(67);

    private final SearchableGraph<Integer> leftLeftChild = new SearchableGraph<>(100);
    private final SearchableGraph<Integer> leftRightChild = new SearchableGraph<>(150);

    private final SearchableGraph<Integer> rightChildChild = new SearchableGraph<>(99);

    @BeforeEach
    void setUp() {
        root.setAdjacent(new SearchableGraph[]{leftChild, middleChild, rightChild});
        leftChild.setAdjacent(new SearchableGraph[]{root, leftLeftChild, leftRightChild, middleChild});
        middleChild.setAdjacent(new SearchableGraph[]{root, leftChild, rightChild});
        rightChild.setAdjacent(new SearchableGraph[]{root, middleChild, rightChildChild});

        leftLeftChild.setAdjacent(new SearchableGraph[]{leftChild, leftRightChild});
        leftRightChild.setAdjacent(new SearchableGraph[]{leftChild, leftLeftChild});
        rightChildChild.setAdjacent(new SearchableGraph[]{rightChild});
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