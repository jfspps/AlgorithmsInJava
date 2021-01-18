package com.algo_data.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class URLifyTest {

    URLify urLify;

    @BeforeEach
    void setUp() {
        urLify = new URLify("https://www.something here and there.com");
    }

    @Test
    void URLifyString() {
        assertEquals("https://www.something%20here%20and%20there.com", urLify.URLifyString());
    }
}