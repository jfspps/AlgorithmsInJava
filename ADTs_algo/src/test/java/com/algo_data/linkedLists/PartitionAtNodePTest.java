package com.algo_data.linkedLists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartitionAtNodePTest {

    LinkedList<Integer> list;
    PartitionAtNodeP partition;

    @BeforeEach
    void setUp() {
        Integer[] integers = {10, 20, 2, 3, 14, 5, 15, 5, 6, 98};
        list = new LinkedList<>(integers);
        partition = new PartitionAtNodeP(list);
    }

    @Test
    void partitionAtTen() {
        // Original list: (Head) 10, 20, 2, 3, 14, 5, 15, 5, 6, 98 (Tail)
        // New head: 2
        // New tail: 20
        // (Head) 3, 14, 5, 15, 5, 6, 98, 10, 20 (Tail)
        // (Head) 5, 15, 5, 6, 98, 10, 20, 14 (Tail)
        // (Head) 5, 6, 98, 10, 20, 14, 15 (Tail)
        // (Head) 6, 98, 10, 20, 14, 15 (Tail)
        // originalTail.next nulled: (Head) 6, 10, 20, 14, 15, 98 (Tail)
        // Partitioned list: (Head) 2, 3, 5, 5, 6, 10, 20, 14, 15, 98 (Tail)

        String partitionAtHead = "(Head) 2, 3, 5, 5, 6, 10, 20, 14, 15, 98 (Tail)";
        LinkedList<Integer> partitionAt10 = partition.partition(10);
        assertEquals(partitionAtHead, partitionAt10.printToString());
    }

    @Test
    void partitionAt98() {
        // Original list: (Head) 10, 20, 2, 3, 14, 5, 15, 5, 6, 98 (Tail)
        // New head: 10
        // New tail: 98
        // originalTail.next nulled: (Head) 10, 20, 2, 3, 14, 5, 15, 5, 6, 98 (Tail)
        // Partitioned list: (Head) 10, 20, 2, 3, 14, 5, 15, 5, 6, 98 (Tail)

        String partitionAtHead = "(Head) 10, 20, 2, 3, 14, 5, 15, 5, 6, 98 (Tail)";
        LinkedList<Integer> partitionAt98 = partition.partition(98);
        assertEquals(partitionAtHead, partitionAt98.printToString());
    }

    @Test
    void partitionAtFive() {
        // Original list: (Head) 10, 20, 2, 3, 14, 5, 15, 5, 6, 98 (Tail)
        // New head: 2
        // New tail: 20
        // (Head) 3, 14, 5, 15, 5, 6, 98, 10, 20 (Tail)
        // (Head) 5, 15, 5, 6, 98, 10, 20, 14 (Tail)
        // (Head) 5, 6, 98, 10, 20, 14, 15 (Tail)
        // (Head) 98, 10, 20, 14, 15, 6 (Tail)
        // Partitioned list: (Head) 2, 3, 5, 5, 98, 10, 20, 14, 15, 6 (Tail)

        String partitionAtHead = "(Head) 2, 3, 5, 5, 98, 10, 20, 14, 15, 6 (Tail)";
        LinkedList<Integer> partitionAt5 = partition.partition(5);
        assertEquals(partitionAtHead, partitionAt5.printToString());
    }
}