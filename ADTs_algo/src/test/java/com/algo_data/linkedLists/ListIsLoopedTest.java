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
        list = new LinkedList<>(new Character[]{ 'a', 'A', 'A', 'd', 'c', 'c', 'c', 'c', 'c', 'c', 'X'});
    }

    @Test
    void isLooped() {
        // head node is not part of the loop
        list.getNode('X').next = list.getNode('d');
        characterListIsLooped = new ListIsLooped<>(list);
        assertEquals('d', characterListIsLooped.getIntersection().getData());
    }

    @Test
    void isLooped2() {
        // head node is part of the loop
        list.getNode('X').next = list.getNode('a');
        characterListIsLooped = new ListIsLooped<>(list);
        assertEquals('a', characterListIsLooped.getIntersection().getData());
    }

    @Test
    void isNotLooped(){
        characterListIsLooped = new ListIsLooped<>(list);
        assertNull(characterListIsLooped.getIntersection());
    }
}