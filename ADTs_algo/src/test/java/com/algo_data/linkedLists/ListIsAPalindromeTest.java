package com.algo_data.linkedLists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListIsAPalindromeTest {

    LinkedList<Character> listEven, listOdd, listError;
    ListIsAPalindrome listIsAPalindrome;

    @BeforeEach
    void setUp() {
        listEven = new LinkedList<>(new Character[]{'a', 'b', 'c', 'c', 'b', 'a'});
        listOdd = new LinkedList<>(new Character[]{'a', 'b', 'c', 'b', 'a'});
        listError = new LinkedList<>(new Character[]{'a', 'c', 'b', 'a'});
    }

    @Test
    void isAPalindromeEven() {
        listIsAPalindrome = new ListIsAPalindrome(listEven);
        assertTrue(listIsAPalindrome.isAPalindrome());
    }

    @Test
    void isAPalindromeOdd() {
        listIsAPalindrome = new ListIsAPalindrome(listOdd);
        assertTrue(listIsAPalindrome.isAPalindrome());
    }

    @Test
    void isNotAPalindrome() {
        listIsAPalindrome = new ListIsAPalindrome(listError);
        assertFalse(listIsAPalindrome.isAPalindrome());
    }
}