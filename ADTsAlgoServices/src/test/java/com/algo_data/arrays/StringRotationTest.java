package com.algo_data.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringRotationTest {

    StringRotation stringRotation;

    @BeforeEach
    void setUp() {
        stringRotation = new StringRotation("bottleOfWine");
    }

    @Test
    void compareTo() {
        String stringB = "WinebottleOf";
        String stringF = "FoodbottleOf";
        String stringC = "OfbottleWine";
        String stringD = "botiadkfksdd";
        String stringE = "fds";

        assertTrue(stringRotation.compareTo(stringB));
        assertFalse(stringRotation.compareTo(stringC));
        assertFalse(stringRotation.compareTo(stringD));
        assertFalse(stringRotation.compareTo(stringE));
        assertFalse(stringRotation.compareTo(stringF));
    }
}