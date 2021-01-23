package com.algo_data.linkedLists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumForwardTest {

    LinkedList<Integer> list;
    LinkedList<Integer> list2;
    LinkedList<Integer> list3;
    SumForward sumForward;
    SumForward sumForward2;
    SumForward sumForward3;

    @BeforeEach
    void setUp() {
        Integer[] evenIntegers = {1, 2, 2, 3, 4, 5};
        Integer[] oddIntegers = {1, 0, 2, 3, 4};
        Integer[] withZeros = {0, 1, 2, 1, 2 };
        list = new LinkedList<>(evenIntegers);
        list2 = new LinkedList<>(oddIntegers);
        list3 = new LinkedList<>(withZeros);
        sumForward = new SumForward(list);
        sumForward2 = new SumForward(list2);
        sumForward3 = new SumForward(list3);
    }

    @Test
    void sumForward() {
        Integer[] evenSum = {4, 6, 7};
        Integer[] oddSum = {1, 3, 6};
        Integer[] withZerosSum = { 2, 4 };
        LinkedList<Integer> evenTest = new LinkedList<>(evenSum);
        LinkedList<Integer> oddTest = new LinkedList<>(oddSum);
        LinkedList<Integer> withZerosTest = new LinkedList<>(withZerosSum);

        assertEquals(evenTest.printToString(), sumForward.sumForward().printToString());
        assertEquals(oddTest.printToString(), sumForward2.sumForward().printToString());
        assertEquals(withZerosTest.printToString(), sumForward3.sumForward().printToString());

        System.out.println(sumForward.sumForward().printToString());
        System.out.println(sumForward2.sumForward().printToString());
        System.out.println(sumForward3.sumForward().printToString());
    }
}