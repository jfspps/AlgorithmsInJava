package com.algo_data.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeTest {

    Palindrome palindrome;
    Palindrome notAPalindrome;

    @BeforeEach
    void setUp() {
        palindrome = new Palindrome("aabbccddeef");
        notAPalindrome = new Palindrome("aabbccddeeffgh");
    }

    @Test
    void stringIsAPermutationOfAPalindrome() {
        assertTrue(palindrome.stringIsAPermutationOfAPalindrome());
        assertFalse(notAPalindrome.stringIsAPermutationOfAPalindrome());
    }
}