package com.algo_data.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OneAwayTest {

    OneAway oneAway;
    OneAway anotherExample;

    @BeforeEach
    void setUp() {
        oneAway = new OneAway("stuvwxyz");
        anotherExample =new OneAway("xxxz");

    }

    @Test
    void isOneAway() {
        assertTrue(oneAway.isOneAway("stuvwxyz"));
        assertTrue(oneAway.isOneAway("stuvwxyz3"));
        assertTrue(oneAway.isOneAway("stuwxyz"));
        assertFalse(oneAway.isOneAway("tooDifferent"));

        assertTrue(anotherExample.isOneAway("xxxx"));
    }
}