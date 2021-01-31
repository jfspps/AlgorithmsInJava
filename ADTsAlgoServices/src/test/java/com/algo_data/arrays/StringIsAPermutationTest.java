package com.algo_data.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringIsAPermutationTest {

    StringIsAPermutation stringIsAPermutation;

    @BeforeEach
    void setUp() {
        stringIsAPermutation = new StringIsAPermutation("aabbccddee");
    }

    @Test
    void isAPermutation1() {
        assertTrue(stringIsAPermutation.isAPermutation("abcdeabcde"));
    }

    @Test
    void isAPermutation2() {
        assertFalse(stringIsAPermutation.isAPermutation("1234567890"));
    }

    @Test
    void isAPermutation_differentLength() {
        assertFalse(stringIsAPermutation.isAPermutation("somethingelse"));
    }
}