package com.algo_data.linkedLists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ListIsLoopedTest {

    LinkedList<Character> list;
    ListIsLooped<Character> characterListIsLooped;

    @BeforeEach
    void setUp() {
        list = new LinkedList<>(new Character[]{ 'a', 'a', 'a', 'd', 'c', 'c', 'c', 'c', 'c', 'c', 'X'});
    }

    @Test
    void isLooped() {
        list.getNode('X').next = list.getNode('d');
        characterListIsLooped = new ListIsLooped<>(list);
        assertEquals('d', characterListIsLooped.getIntersection().getData());
    }

    @Test
    void isNotLooped(){
        characterListIsLooped = new ListIsLooped<>(list);
        assertNull(characterListIsLooped.getIntersection());
    }
}