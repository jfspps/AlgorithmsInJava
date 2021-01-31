package com.algo_data.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCompressionTest {

    StringCompression stringCompression;

    @BeforeEach
    void setUp() {
        stringCompression = new StringCompression("aaaabbbccdeEEEEGggaa");
    }

    @Test
    void compress() {
        assertEquals("a4b3c2deE4Gg2a2", stringCompression.compress());
        assertNotEquals("a3b3c2deE4Gg2a2", stringCompression.compress());
    }
}