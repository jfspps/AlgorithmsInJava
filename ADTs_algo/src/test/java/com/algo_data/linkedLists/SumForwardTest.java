package com.algo_data.linkedLists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumForwardTest {

    LinkedList<Integer> list;
    LinkedList<Integer> list2;
    SumForward sumForward;
    SumForward sumForward2;

    @BeforeEach
    void setUp() {
        Integer[] evenIntegers = {1, 2, 2, 3, 4, 5};
        Integer[] oddIntegers = {1, 0, 2, 3, 4};
        list = new LinkedList<>(evenIntegers);
        list2 = new LinkedList<>(oddIntegers);
        sumForward = new SumForward(list);
        sumForward2 = new SumForward(list2);
    }

    @Test
    void sumForward() {
        Integer[] evenSum = {4, 6, 7};
        Integer[] oddSum = {1, 3, 6};
        LinkedList<Integer> evenTest = new LinkedList<>(evenSum);
        LinkedList<Integer> oddTest = new LinkedList<>(oddSum);

        assertEquals(evenTest.printToString(), sumForward.sumForward().printToString());
        assertEquals(oddTest.printToString(), sumForward2.sumForward().printToString());

        System.out.println(sumForward.sumForward().printToString());
        System.out.println(sumForward2.sumForward().printToString());
    }
}